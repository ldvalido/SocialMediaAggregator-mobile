package ar.com.redbee.socialmediaaggregator.commons.logger;

import android.util.Log;
public class LoggerHelper {
    public static void d(Exception e, String tag) {
        Log.d(tag, Log.getStackTraceString(e));
    }

    public static void d(String message, String tag) {
        Log.d(tag, message);
    }

    public static void e(Exception e, String tag) {
        Log.e(tag, Log.getStackTraceString(e));
    }

    public static void e(String message, String tag) {
        Log.e(tag, message);
    }

    public static void w(Exception e, String tag) {
        Log.w(tag, Log.getStackTraceString(e));
    }

    public static void w(String message, String tag) {
        Log.w(tag, message);
    }

    public static void i(Exception e, String tag) {
        Log.i(tag, Log.getStackTraceString(e));
    }


    public static void i(String message, String tag) {
        Log.i(tag, message);
    }

    public static void v(Exception e, String tag) {
        Log.v(tag, Log.getStackTraceString(e));
    }

    public static void v(String message, String tag) {
        Log.v(tag, message);
    }

    public static void wtf(Exception e, String tag) {
        Log.wtf(tag, e);
    }

    public static void wtf(String message, String tag) {
        Log.wtf(tag, message);
    }
}
