
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.ciphergateway.crypto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

public class NativeUtils {

    private NativeUtils() {}

    /** 我们自己创建的临时目录前缀（只清理这个前缀的目录） */
    private static final String TMP_PREFIX = "cgcipherjni-";

    /** 只做一次清理 */
    private static volatile boolean cleanedOnce = false;

    /* ====================== 外部调用入口 ====================== */

    /** 按当前 OS/ARCH 自动选择并加载 CGCipherJNI 本地库 */
    public static synchronized void loadLibraryFromJar() {
        lazyCleanOnce();

        String os = System.getProperty("os.name", "").toLowerCase(Locale.ROOT);
        String arch = System.getProperty("os.arch", "").toLowerCase(Locale.ROOT);

        String baseDir = "/com/ciphergateway/crypto/resources/";
        String subDir;
        String fileName; // jar 内的资源名

        if (isWindows(os)) {
            subDir = "windows/";
            fileName = "CGCipherJNI.dll";
        } else if (isLinux(os)) {
            subDir = "linux/";
            fileName = pickLinuxVariant(arch, readCpuInfo());
        } else if (isMac(os)) {
            // 若你已有 mac 库，可按需细分 aarch64/x86_64 目录
            throw new UnsupportedOperationException("No macOS native library packaged yet.");
        } else {
            throw new UnsupportedOperationException("Unsupported OS: " + os + ", arch: " + arch);
        }

        String resourcePath = baseDir + subDir + fileName;
        loadFromResource(resourcePath, fileName);
    }

    /* 可选：如果你想手工指定资源路径，也可以开放这个重载 */
    public static synchronized void loadLibraryFromJar(String resourcePath) {
        lazyCleanOnce();
        String fileName = resourcePath.substring(resourcePath.lastIndexOf('/') + 1);
        loadFromResource(resourcePath, fileName);
    }

    /* ====================== 核心实现 ====================== */

    private static void loadFromResource(String resourcePath, String fileName) {
        try (InputStream in = NativeUtils.class.getResourceAsStream(resourcePath)) {
            if (in == null) {
                throw new FileNotFoundException("Native lib not found in jar: " + resourcePath);
            }

            Path tempDir = Files.createTempDirectory(TMP_PREFIX);

            // 目标文件名需要是系统可识别的扩展名：
            //  - linux: .so
            //  - windows: .dll
            // 如果资源带了变体后缀（.so.loongson/.so.youhua），解压时改回标准后缀。
            String mappedName = mapExtractedName(fileName);
            Path tempLib = tempDir.resolve(mappedName);

            Files.copy(in, tempLib, StandardCopyOption.REPLACE_EXISTING);

            // 赋执行权限（Windows/不支持 POSIX 会忽略异常）
            try {
                Set<PosixFilePermission> perms = EnumSet.of(
                        PosixFilePermission.OWNER_READ, PosixFilePermission.OWNER_WRITE, PosixFilePermission.OWNER_EXECUTE,
                        PosixFilePermission.GROUP_READ, PosixFilePermission.GROUP_EXECUTE,
                        PosixFilePermission.OTHERS_READ, PosixFilePermission.OTHERS_EXECUTE
                );
                Files.setPosixFilePermissions(tempLib, perms);
            } catch (Exception ignore) {}

            // 打印证据链，方便在两种运行方式下对比
            String sha = sha256(tempLib);
            System.out.println("[JNI] resource = " + resourcePath);
            System.out.println("[JNI] extracted= " + tempLib.toAbsolutePath());
            System.out.println("[JNI] sha256   = " + sha);

            System.load(tempLib.toAbsolutePath().toString());

            // 退出清理
            tempLib.toFile().deleteOnExit();
            tempDir.toFile().deleteOnExit();
        } catch (IOException e) {
            throw new RuntimeException("Failed to load native lib: " + resourcePath, e);
        }
    }

    /** Linux 下根据 arch/cpu 信息挑选变体文件名 */
    private static String pickLinuxVariant(String arch, String cpuInfo) {
        final String a = arch == null ? "" : arch.toLowerCase(Locale.ROOT);
        final String c = cpuInfo == null ? "" : cpuInfo.toLowerCase(Locale.ROOT);

        // 你的资源命名规则：
        //   libCGCipherJNI.so            -> 通用 x86_64
        //   libCGCipherJNI.so.loongson   -> 龙芯
        //   libCGCipherJNI.so.youhua     -> 优化/飞腾/ARM64 变体（按你项目中实际含义）
        if (a.contains("loong") || c.contains("loong")) {
            return "libCGCipherJNI.so.loongson";
        }
        if (a.contains("aarch64") || a.contains("arm64") || c.contains("phytium") || c.contains("youhua")) {
            return "libCGCipherJNI.so.youhua";
        }
        // 默认 x86_64
        return "libCGCipherJNI.so";
    }

    /** 资源名转为解压的文件名（写回标准后缀，便于 System.load） */
    private static String mapExtractedName(String resourceName) {
        if (resourceName.endsWith(".dll")) return resourceName; // windows
        // linux: 把 .so.* 变体解压成 .so
        if (resourceName.startsWith("lib") && resourceName.contains(".so")) {
            return "libCGCipherJNI.so";
        }
        return resourceName;
    }

    /* ====================== 一次性临时清理 ====================== */

    private static void lazyCleanOnce() {
        if (cleanedOnce) return;
        synchronized (NativeUtils.class) {
            if (cleanedOnce) return;
            try { cleanOldNativeTempDirs(); }
            catch (Exception e) { System.err.println("[JNI] temp cleanup skipped: " + e.getMessage()); }
            cleanedOnce = true;
        }
    }

    /** 只清理系统临时目录下、以我们前缀命名的目录，避免误删 */
    private static void cleanOldNativeTempDirs() throws IOException {
        String tmp = System.getProperty("java.io.tmpdir");
        if (tmp == null || tmp.isEmpty()) return;
        Path tmpDir = Paths.get(tmp);
        if (!Files.isDirectory(tmpDir)) return;

        try (DirectoryStream<Path> ds = Files.newDirectoryStream(tmpDir, TMP_PREFIX + "*")) {
            for (Path p : ds) {
                if (Files.isDirectory(p) && p.getFileName().toString().startsWith(TMP_PREFIX)) {
                    deleteRecursivelyQuietly(p);
                }
            }
        }
    }

    private static void deleteRecursivelyQuietly(Path root) {
        try {
            Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    try { Files.deleteIfExists(file); } catch (Exception ignore) {}
                    return FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    try { Files.deleteIfExists(dir); } catch (Exception ignore) {}
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (Exception ignore) {}
    }

    /* ====================== 工具方法 ====================== */

    private static boolean isWindows(String os) { return os.contains("win"); }
    private static boolean isLinux(String os)   { return os.contains("nux") || os.contains("linux"); }
    private static boolean isMac(String os)     { return os.contains("mac"); }

    /** 读取 /proc/cpuinfo（Linux 下有效），用于识别 loongson/phytium 等关键字 */
    private static String readCpuInfo() {
        Path p = Paths.get("/proc/cpuinfo");
        if (Files.isReadable(p)) {
            try {
                return new String(Files.readAllBytes(p));
            } catch (IOException ignore) {}
        }
        return "";
    }

    /** 计算文件 sha256 用于对比诊断 */
    private static String sha256(Path p) {
        try (InputStream in = Files.newInputStream(p)) {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] buf = new byte[4096];
            int n;
            while ((n = in.read(buf)) != -1) md.update(buf, 0, n);
            byte[] d = md.digest();
            StringBuilder sb = new StringBuilder(d.length * 2);
            for (byte b : d) sb.append(String.format("%02x", b));
            return sb.toString();
        } catch (Exception e) {
            return "n/a";
        }
    }
}
