package com.databox.im.utils;

/**
 * Date：2021/7/15
 * Time：14:20
 * author:Stenven
 **/

import android.util.Log;

import com.databox.im.common.Constant;


/**
 * Log统一管理类
 *
 */
public class NatureLog
{

    // 是否需要打印bug，可以在application的onCreate函数里面初始化
    public static boolean isDebug = Constant.IS_DEBUG;
    private static final String TAG = "魔镜";

    // 下面四个是默认tag的函数
    public static void i(String msg)
    {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg)
    {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg)
    {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg)
    {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            Log.e(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            Log.v(tag, msg);
    }
}
