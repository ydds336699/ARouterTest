package com.ydds.librouter;

import android.util.Log;

/**
 * Description:   TODO (用一句话描述该文件做什么)
 * author:        Administrator
 * version:       V1.0
 * Date:          2019/4/30
 */
public class RLog {

    private static final String TAG = "LibRouter";

    public static void i(String msg) {
        Log.i(TAG, msg);
    }

    public static void w(String msg) {
        Log.w(TAG, msg);
    }

    public static void d(String msg) {
        Log.d(TAG, msg);
    }

    public static void e(String msg) {
        Log.e(TAG, msg);
    }
}
