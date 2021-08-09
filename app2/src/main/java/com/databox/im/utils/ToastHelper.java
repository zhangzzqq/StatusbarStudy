package com.databox.im.utils;

import android.content.Context;
import android.widget.Toast;


/**
 *
 * On 2020/11/5 11:32
 *
 * Description
 */
public class ToastHelper {
    private ToastHelper() {
    }


    public static void showOk(Context context, String s) {

        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }

    public static void showOther(Context context, String s) {
        Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
    }
}
