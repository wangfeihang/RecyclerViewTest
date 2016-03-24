package com.example.administrator.recyclerviewtest;

/**
 * Created by Administrator on 2016/3/22.
 */
public class HttpUtils {

    public interface Callback{
        void onRequestSuccess(String json);
    }
    public static void request(String url, final Callback mcallback){

        HttpRequestBuilder httpRequestBuilder = new HttpRequestConcreteBuilder();
        HttpRequestDirector httpRequestDirector = new HttpRequestDirector(httpRequestBuilder);
        httpRequestDirector.construct(url, mcallback);
        HttpRequestProduct httpRequestProduct = httpRequestBuilder.retrieveResult();

        httpRequestProduct.getClient().newCall(httpRequestProduct.getRequest()).enqueue(httpRequestProduct.getCallback());

    }
}
