package com.example.administrator.recyclerviewtest;

import com.squareup.okhttp.OkHttpClient;

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
    String httpUrl = "http://apis.baidu.com/apistore/weatherservice/weather";
    String httpArg = "citypinyin=beijing";
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
        httpUrl = "http://apis.baidu.com/apistore/weatherservice/weather";
        httpArg ="citypinyin=beijing";
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        httpUrl = httpUrl + "?" + httpArg;



        OkHttpClient client = new OkHttpClient();

        String run(String url) throws IOException {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = client.newCall(request).execute();
            return response.body().string();
        }

        public static void main(String[] args) throws IOException {
            GetExample example = new GetExample();
            String response = example.run("https://raw.github.com/square/okhttp/master/README.md");
            System.out.println(response);
        }









        try {

            URL url = new URL(httpUrl);
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("GET");
            // 填入apikey到HTTP header
            connection.setRequestProperty("apikey",  "b7c0e80f7e2a8767a3886952c632ed79");
            connection.connect();
            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
