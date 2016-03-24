package com.example.administrator.recyclerviewtest;

/**
 * Created by Administrator on 2016/3/24.
 */
public interface HttpRequestBuilder {
    public void buildClient();
    public void buildRequest(String url);
    public void bulidCallback(HttpUtils.Callback mcallback);
    public HttpRequestProduct retrieveResult();
}
