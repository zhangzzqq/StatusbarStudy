package com.databox.im.api;

/**
 * Date：2021/5/15
 * Time：12:05
 * author:Stenven
 **/

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class CustomerInterceptor implements Interceptor {
    private static final String TAG = "CustomerInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
//
//        Response response = chain.proceed(request);
//        MLog.e(response.toString());
//        //自动上传token
//        Request updateRequest = request.newBuilder()
//                .header("token", BaseApplication.getInstance().getToken())
//                .build();
//        return chain.proceed(updateRequest);


        if (request.url().host().equals("test")) {
            Request newRequest = request.newBuilder().url("test2").build();
            return chain.proceed(newRequest);
        } else {
            return chain.proceed(request);
        }
    }
}
