package com.databox.im.api;

/**
 * Date：2021/5/15
 * Time：12:50
 * author:Stenven
 **/
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author steven
 * @Description  判断token是否过期
 * @Date  2021/5/15 12:53
 **/

public class TokenInterceptor implements Interceptor {

    private static final String TAG = "TokenInterceptor";

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        //根据和服务端的约定判断token过期
        if (isTokenExpired(response)) {
            //同步请求方式，获取最新的Token
            String newToken = getNewToken();
            //使用新的Token，创建新的请求
            Request newRequest = chain.request()
                    .newBuilder()
                    .header("token" ,newToken)
                    .build();
            //重新请求
            return chain.proceed(newRequest);
        }
        return response;
    }

    /**
     * 根据Response，判断Token是否失效
     *
     * @param response
     * @return
     */
    private boolean isTokenExpired(Response response) {
        if (response.code() == 301) {
            return true;
        }
        return false;
    }

    /**
     * 同步请求方式，获取最新的Token
     *
     * @return
     */
    private String getNewToken() {
        /**
         * 必须使用同步请求
         */
        String newToken = "";

        String url =null;
        OkHttpClient client = new OkHttpClient.Builder().
                readTimeout(5, TimeUnit.SECONDS).build();
        Request request = new Request.Builder().url(url)
                .get().build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
            newToken = response.body().string();
            return newToken;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newToken;
    }



}
