package com.databox.im.utils;


import com.databox.im.common.Constant;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.DiskLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * @Author steven
 * @Description  log工具类
 * @Date  2021/5/12 13:34
 * @Param
 * @return
 **/
public class MLog {

    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int ASSERT = 7;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    public static  void init(String tag) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
                .methodCount(1)         // (Optional) How many method line to show. Default 2
                .methodOffset(5)        // (Optional) Hides internal method calls up to offset. Default 5
//                .logStrategy(customLog) // (Optional) Changes the log strategy to print out. Default LogCat
                .tag(tag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
                .build();
        Logger.addLogAdapter(new DiskLogAdapter());//保存的日志文件地址是 根目录/logger/
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }


    public static void log(int priority, String tag, String message, Throwable throwable) {
        if (Constant.IS_DEBUG) {
            Logger.log(priority, tag, message, throwable);
        }
    }

    public static void d(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.d(message, args);
        }
    }

    public static void d(Object object) {
        if (Constant.IS_DEBUG) {
            Logger.d(object);
        }
    }

    public static void e(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.e(null, message, args);
        }
    }

    public static void e(Throwable throwable, String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.e(throwable, message, args);
        }
    }

    public static void i(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.i(message, args);
        }
    }

    public static void v(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.v(message, args);
        }
    }

    public static void w(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.w(message, args);
        }
    }

    public static void wtf(String message, Object... args) {
        if (Constant.IS_DEBUG) {
            Logger.wtf(message, args);
        }
    }

    /**
     * Formats the json content and print it
     *
     * @param json the json content
     */
    public static void json(String json) {
        if (Constant.IS_DEBUG) {
            Logger.json(json);
        }
    }

    /**
     * Formats the json content and print it
     *
     * @param xml the xml content
     */
    public static void xml(String xml) {
        if (Constant.IS_DEBUG) {
            Logger.xml(xml);
        }
    }

}
