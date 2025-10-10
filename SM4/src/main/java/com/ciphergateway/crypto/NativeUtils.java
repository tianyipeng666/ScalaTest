package com.ciphergateway.crypto;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

public final class NativeUtils {

    private NativeUtils() {}

    /** 固定资源路径：默认就从这里拿 Linux x86_64 的 .so */
    private static final String DEFAULT_RESOURCE = "/com/ciphergateway/crypto/resources/linux/libCGCipherJNI.so";

    /** 我们创建的临时目录前缀（只清理这个前缀） */
    private static final String TMP_PREFIX = "cgcipherjni-";
    private static volatile boolean cleanedOnce = false;

    /* ====================== 对外入口 ====================== */

    /** 按固定资源路径加载（不区分系统、不探测架构） */
    public static synchronized void loadLibraryFromJar() {
        lazyCleanOnce();
        loadFromResource(DEFAULT_RESOURCE, "libCGCipherJNI.so");
    }

    /**
     * 可选重载：
     * - 若传入以 "/" 开头的类路径（如 "/xxx/libCGCipherJNI.so"），则从 JAR 资源加载；
     * - 若传入本地绝对路径（如 "/opt/lib/libCGCipherJNI.so"），则直接 System.load。
     */
    public static synchronized void loadLibrary(String pathOrResource) {
        lazyCleanOnce();
        if (pathOrResource == null || pathOrResource.isEmpty()) {
            loadLibraryFromJar();
            return;
        }
        // 绝对路径：直接加载
        if (Paths.get(pathOrResource).isAbsolute()) {
            System.out.println("[JNI] load local file = " + pathOrResource);
            System.load(pathOrResource);
            return;
        }
        // 否则按资源路径处理
        String fileName = pathOrResource.substring(pathOrResource.lastIndexOf('/') + 1);
        loadFromResource(pathOrResource, fileName);
    }

    /* ====================== 核心实现 ====================== */

    private static void loadFromResource(String resourcePath, String fileName) {
        try (InputStream in = NativeUtils.class.getResourceAsStream(resourcePath)) {
            if (in == null) throw new FileNotFoundException("Native lib not found in jar: " + resourcePath);

            Path tempDir = Files.createTempDirectory(TMP_PREFIX);
            Path tempLib = tempDir.resolve("libCGCipherJNI.so"); // 统一落地名

            Files.copy(in, tempLib, StandardCopyOption.REPLACE_EXISTING);

            // 尝试赋执行权限（不支持 POSIX 的系统会忽略）
            try {
                Set<PosixFilePermission> perms = EnumSet.of(
                        PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE,
                        PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE,
                        PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_EXECUTE
                );
                Files.setPosixFilePermissions(tempLib, perms);
            } catch (Throwable ignore) {}

            // 证据日志
            System.out.println("[JNI] resource = " + resourcePath);
            System.out.println("[JNI] extracted= " + tempLib.toAbsolutePath());
            System.out.println("[JNI] sha256   = " + sha256(tempLib));

            System.load(tempLib.toAbsolutePath().toString());

            tempLib.toFile().deleteOnExit();
            tempDir.toFile().deleteOnExit();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native lib: " + resourcePath, e);
        }
    }

    /* ====================== 一次性清理 ====================== */

    private static void lazyCleanOnce() {
        if (cleanedOnce) return;
        synchronized (NativeUtils.class) {
            if (cleanedOnce) return;
            try { cleanOldNativeTempDirs(); } catch (Exception e) {
                System.err.println("[JNI] temp cleanup skipped: " + e.getMessage());
            }
            cleanedOnce = true;
        }
    }

    private static void cleanOldNativeTempDirs() throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        if (tmp == null || tmp.isEmpty()) return;
        Path tmpDir = Paths.get(tmp);
        if (!Files.isDirectory(tmpDir)) return;

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir, TMP_PREFIX + "*")) {
            for (Path p : ds) deleteRecursivelyQuietly(p);
        }
    }

    private static void deleteRecursivelyQuietly(Path root) {
        try {
            Files.walk(root)
                    .sorted((a, b) -> b.getNameCount() - a.getNameCount()) // 先删子再删父
                    .forEach(path -> { try { Files.deleteIfExists(path); } catch (Exception ignore) {} });
        } catch (Exception ignore) {}
    }

    /* ====================== 小工具 ====================== */

    private static String sha256(Path p) {
        try (InputStream in = Files.newInputStream(p)) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buf = new byte[4096];
            int n;
            while ((n = in.read(buf)) != -1) md.update(buf, 0, n);
            byte[] d = md.digest();
            StringBuilder sb = new StringBuilder(d.length * 2);
            for (byte b : d) sb.append(String.format(Locale.ROOT, "%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "n/a";
        }
    }
}