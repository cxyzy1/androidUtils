package com.cxyzy.androidutils;

import android.util.Log;

public class LogUtil {
    private static boolean IS_ERR = true;

    private static boolean IS_DEBUG = true;

    private static boolean IS_WARN = true;

    private static boolean IS_INFO = true;

    private static boolean IS_VERBOSE = true;

    public static void setDebugMode(boolean debug) {
        if (!debug) {
            IS_ERR = false;
            IS_DEBUG = false;
            IS_WARN = false;
            IS_INFO = false;
            IS_VERBOSE = false;
        }
    }

    public static void d(String tag, String text) {
        if (IS_DEBUG) {
            Log.d(tag, text);
        }
    }

    public static void i(String tag, String text) {
        if (IS_INFO) {
            Log.i(tag, text);
        }
    }

    public static void w(String tag, String text) {
        if (IS_WARN) {
            Log.w(tag, text);
        }
    }

    public static void v(String tag, String text) {
        if (IS_VERBOSE) {
            Log.w(tag, text);
        }
    }

    public static void e(String tag, String text) {
        if (IS_ERR) {
            Log.e(tag, text);
        }
    }

    public static void e(String tag, Throwable tr) {
        if (IS_ERR) {
            Log.e(tag, StackTraceUtil.getStackTraceString(tr));
        }
    }
}
