package com.databox.im.base;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;
import com.databox.im.BuildConfig;
import com.databox.im.api.CustomerInterceptor;
import com.databox.im.common.Constant;
import com.databox.im.utils.MLog;
import com.tencent.bugly.crashreport.CrashReport;

import okhttp3.OkHttpClient;


/**
 *
 * Description
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // 初始化日志类
        MLog.init(Constant.DEFAULT_TAG);
        //初始化网络框架AndroidNetworking
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        //设置日志打印级别
        if (BuildConfig.DEBUG) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        }
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .addNetworkInterceptor(loggingInterceptor)
                .addInterceptor(new CustomerInterceptor())
                .build();
        AndroidNetworking.initialize(getApplicationContext(), okHttpClient);

        //bugly
//        CrashReport.initCrashReport(getApplicationContext(), Constant.BUGLY_APPID, false);

    }


}
