package com.example.statusbarstudy.base;

import android.app.Application;

import com.qmuiteam.qmui.arch.QMUISwipeBackActivityManager;

/**
 * Date：2021/5/19
 * Time：10:27
 * author:Stenven
 **/
public  class APP extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QMUISwipeBackActivityManager.init(this);

    }
}
