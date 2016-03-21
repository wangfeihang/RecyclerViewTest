package com.example.administrator.recyclerviewtest;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/3/21.
 */
public class JsonHelper {

    public static WeatherBean ParseJson(String jsonString) {

        // 以employee为例解析，map类似
        JSONObject jb = null;
        String errMsg;
        try {
            jb = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jbData = null;
        try {
            jbData = jb.getJSONObject("retData");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        WeatherBean weatherBean = new WeatherBean();
        try {
            weatherBean.setDate(jbData.getString("date"));
            weatherBean.setWeather(jbData.getString("weather"));
            weatherBean.setTemp(jbData.getString("temp"));
            weatherBean.setWD(jbData.getString("WD"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return weatherBean;

    }

}
