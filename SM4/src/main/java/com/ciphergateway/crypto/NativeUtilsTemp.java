
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.ciphergateway.crypto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.regex.Pattern;

public class NativeUtilsTemp {
    private static final int MIN_PREFIX_LENGTH = 3;
    public static final String NATIVE_FOLDER_PATH_PREFIX = "nativeutils";
    private static File temporaryDir;

    static {
        try {
            File tempfile = createTempDirectory("nativeutils");
            String path = "";
            if (isWindows()) {
                path = tempfile.getPath().substring(0, tempfile.getPath().lastIndexOf("\\"));
            } else {
                path = tempfile.getPath().substring(0, tempfile.getPath().lastIndexOf("/"));
            }

            delFilesByPath(path, "nativeutils");
        } catch (Exception var2) {
            System.err.println("Temp folder delete faild");
        }

    }

    private NativeUtilsTemp() {
    }

    public static void loadLibraryFromJar(String path) throws IOException {
        if (path != null && path.startsWith("/")) {
            String[] parts = path.split("/");
            String filename = parts.length > 1 ? parts[parts.length - 1] : null;
            if (filename != null && filename.length() >= 3) {
                if (temporaryDir == null) {
                    temporaryDir = createTempDirectory("nativeutils");
                    temporaryDir.deleteOnExit();
                }

                File temp = new File(temporaryDir, filename);

                try {
                    InputStream is = NativeUtilsTemp.class.getResourceAsStream(path);
                    OutputStream os = new FileOutputStream(temp);
                    byte[] buffer = new byte[200];
                    int blen = 200;

                    int len;
                    while((len = is.read(buffer, 0, blen)) != -1) {
                        os.write(buffer, 0, len);
                    }

                    is.close();
                    os.close();
                } catch (IOException var15) {
                    temp.delete();
                    throw var15;
                } catch (NullPointerException var16) {
                    temp.delete();
                    throw new FileNotFoundException("File " + path + " was not found inside JAR.");
                }

                try {
                    System.load(temp.getAbsolutePath());
                } catch (Exception var13) {
                    temp.delete();
                    throw new FileNotFoundException("File " + temporaryDir + " was not found " + filename);
                } finally {
                    temp.deleteOnExit();
                }

            } else {
                throw new IllegalArgumentException("The filename has to be at least 3 characters long.");
            }
        } else {
            throw new IllegalArgumentException("The path has to be absolute (start with '/').");
        }
    }

    private static File createTempDirectory(String prefix) throws IOException {
        String tempDir = System.getProperty("java.io.tmpdir");
        File generatedDir = new File(tempDir, prefix + System.nanoTime());
        if (!generatedDir.mkdir()) {
            throw new IOException("Failed to create temp directory " + generatedDir.getName());
        } else {
            return generatedDir;
        }
    }

    private static void deleteFolder(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            File[] var5 = files;
            int var4 = files.length;

            for(int var3 = 0; var3 < var4; ++var3) {
                File f = var5[var3];
                if (f.isDirectory()) {
                    deleteFolder(f);
                } else {
                    f.delete();
                }
            }
        }

        file.delete();
    }

    public static void delFilesByPath(String path, String str) {
        File file = new File(path);
        File[] tempFile = file.listFiles();

        for(int i = 0; i < tempFile.length; ++i) {
            if (tempFile[i].getName().startsWith(str) && tempFile[i].isDirectory()) {
                deleteFolder(tempFile[i]);
            }
        }

    }

    public static boolean isWindows() {
        String OS = System.getProperty("os.name").toLowerCase();
        return OS.toLowerCase().indexOf("windows") >= 0;
    }

    public static boolean isNumber(String str) {
        Pattern pattern = null;
        if (str.contains(".")) {
            pattern = Pattern.compile("[0-9]+.[0-9]+");
        } else {
            pattern = Pattern.compile("[0-9]*");
        }

        return pattern.matcher(str).matches();
    }
}
