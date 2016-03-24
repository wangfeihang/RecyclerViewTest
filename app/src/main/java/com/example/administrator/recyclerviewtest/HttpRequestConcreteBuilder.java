package com.example.administrator.recyclerviewtest;

import android.os.Handler;
import android.os.Looper;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by Administrator on 2016/3/24.
 */
public class HttpRequestConcreteBuilder implements HttpRequestBuilder {

    private HttpRequestProduct httpRequestProduct = new HttpRequestProduct();

    @Override
    public void buildClient() {
        OkHttpClient client = new OkHttpClient();
        httpRequestProduct.setClient(client);
    }

    @Override
    public void buildRequest(String url) {
        Request request = new Request.Builder()
                .url(url)
                .header("apikey", "b7c0e80f7e2a8767a3886952c632ed79")
                .build();
        httpRequestProduct.setRequest(request);
    }
    @Override
    public void bulidCallback(final HttpUtils.Callback mcallback)
    {


        com.squareup.okhttp.Callback callback=new com.squareup.okhttp.Callback() {
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
                        mcallback.onRequestSuccess(result);
                    }
                });

            }
        };
        httpRequestProduct.setCallback(callback);
    }
    @Override
    public HttpRequestProduct retrieveResult() {
        return httpRequestProduct;
    }
}
