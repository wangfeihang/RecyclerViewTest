package com.example.administrator.recyclerviewtest;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Created by Administrator on 2016/3/20.
 */
public class Connection {

  //  String jsonResult = request(httpUrl, httpArg);
   // System.out.println(jsonResult);

    /**
     * @param urlAll
     *            :请求接口
     * @param httpArg
     *            :参数
     * @return 返回结果
     */
    public static String request(String httpUrl, String httpArg) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;



        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(httpUrl)
                .header("apikey", "b7c0e80f7e2a8767a3886952c632ed79")
                .build();

        Response response = null;
        try {
            response = client.newCall(request).execute();
            result=response.body().string()+"";
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        return result;
    }

}
