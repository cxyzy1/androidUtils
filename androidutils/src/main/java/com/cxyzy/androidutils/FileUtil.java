package com.cxyzy.androidutils;

import androidx.annotation.NonNull;

import java.io.*;
import java.nio.charset.Charset;

public class FileUtil {
    private static final String TAG = FileUtil.class.getSimpleName();
    private static Charset mCharset = Charset.defaultCharset();
    private static final String NEW_LINE = System.getProperty("line.separator");

    public static Class setCharset(Charset charset) {
        mCharset = charset;
        return FileUtil.class;
    }

    public static void deleteFileOrDir(File file) {
        if (file.isDirectory()) {
            File[] fileArr = file.listFiles();
            for (File fileInArr : fileArr) {
                deleteFileOrDir(fileInArr);
            }
        } else {
            file.delete();
        }
    }

    /**
     * copy files from srcDir to destDir
     */
    public static boolean copyDir(final File srcDir,
                                  final File destDir) {
        if (srcDir == null || destDir == null) {
            return false;
        }
        // destDir's path locate in srcDir's path then return false
        String srcPath = srcDir.getPath() + File.separator;
        String destPath = destDir.getPath() + File.separator;
        if (destPath.contains(srcPath)) {
            return false;
        }
        if (!srcDir.exists() || !srcDir.isDirectory()) {
            return false;
        }
        if (!createOrExistsDir(destDir)) {
            return false;
        }
        File[] files = srcDir.listFiles();
        for (File file : files) {
            File destFile = new File(destPath + file.getName());
            if (file.isFile()) {
                if (!copyFile(file, destFile)) {
                    return false;
                }
            } else if (file.isDirectory()) {
                if (!copyDir(file, destFile)) {
                    return false;
                }
            }
        }
        return true;

    }

    private static boolean createOrExistsDir(final File file) {
        return file.exists() ? file.isDirectory() : file.mkdirs();
    }

    private static boolean copyFile(final File srcFile, final File destFile) {
        try (InputStream is = new FileInputStream(srcFile);
             OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile))) {
            byte[] data = new byte[8192];
            int len;
            while ((len = is.read(data)) != -1) {
                os.write(data, 0, len);
            }
            return true;
        } catch (IOException e) {
            LogUtil.e(TAG, e);
            return false;
        }
    }

    /**
     * Read all content of a file and return as String. Notice: line feed will be changed to as same as System.
     *
     * @param filePath
     * @return
     */
    public static String getFileContent(@NonNull String filePath) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), mCharset))) {
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (!isFirstLine) {
                    sb.append(NEW_LINE);
                }
                sb.append(line);
                isFirstLine = false;
            }
        } catch (Exception e) {
            LogUtil.e(TAG, e);
        }
        return sb.toString();
    }

    public static void writeFile(@NonNull String filePath, @NonNull String content) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath), mCharset)) {
            osw.write(content);
        } catch (Exception e) {
            LogUtil.e(TAG, e);
        }
    }

    public static void appendContent(@NonNull String filePath, @NonNull String content) {
        try (OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(filePath, true), mCharset)) {
            osw.write(content);
        } catch (Exception e) {
            LogUtil.e(TAG, e);
        }
    }

    public static void createNewFile(String filePath) {
        createNewFile(new File(filePath));
    }

    public static void createNewFile(File f) {
        try {
            f.createNewFile();
        } catch (IOException e) {
            LogUtil.e(TAG, e);
        }
    }

    public static void deleteFile(@NonNull String filePath) {
        File f = new File(filePath);
        if (f.exists()) {
            f.delete();
        }
    }
}
