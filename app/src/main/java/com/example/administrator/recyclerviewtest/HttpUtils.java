package com.example.administrator.recyclerviewtest;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2016/3/22.
 */
public class HttpUtils {

    public interface Callback{
        void onRequestSuccess(String json);
    }
    public static void request(String url, final Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .header("apikey", "b7c0e80f7e2a8767a3886952c632ed79")
                .build();
        client.newCall(request).enqueue(new com.squareup.okhttp.Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }
                final String result = response.body().string() + "";
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        callback.onRequestSuccess(result);
                    }
                });

            }
        });
    }
}
