package com.example.administrator.recyclerviewtest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class JsonHelper {


    /**
     * @param jsonString
     *            :单日获得的json字符串
     * @return 返回结果
     */
    public static WeatherBean ParseJson(String jsonString) {

        JSONObject jsonObject = null;
        String errMsg;
        try {
            jsonObject = new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jbData = null;
        try {
            jbData = jsonObject.getJSONObject("retData");
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

    /**
     * @param jsonString
     *            :多日获得的json字符串
     * @return 返回结果
     */
    public static List<WeatherBean> ParseRecentWeathersJson(String jsonString)
    {
        List<WeatherBean> weatherBeanList=new ArrayList<WeatherBean>();
        JSONObject jsonObject = null;
        JSONObject jsonObjectData = null;
        JSONObject todayJsonObject=null;
        JSONArray forecastJsonArray = null;
        JSONArray historyJsonArray = null;
        String errMsg;
        try {
            jsonObject = new JSONObject(jsonString);
            jsonObjectData=jsonObject.getJSONObject("retData");
            todayJsonObject=jsonObjectData.getJSONObject("today");
            forecastJsonArray= jsonObjectData.getJSONArray("forecast");
            historyJsonArray = jsonObjectData.getJSONArray("history");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        for(int i=0;i<historyJsonArray.length();i++)
        {
            try {
                JSONObject jbData=historyJsonArray.getJSONObject(i);
                weatherBeanList.add(getWeatherBean(jbData));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        weatherBeanList.add(getWeatherBean(todayJsonObject));
        for(int i=0;i<forecastJsonArray.length();i++)
        {
            try {
                JSONObject jbData=forecastJsonArray.getJSONObject(i);
                weatherBeanList.add(getWeatherBean(jbData));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        return weatherBeanList;


    }
    public static WeatherBean getWeatherBean(JSONObject jbData)
    {
        WeatherBean weatherBean = new WeatherBean();
        try {
            weatherBean.setDate(jbData.getString("date"));
            weatherBean.setWeather(jbData.getString("type"));
            weatherBean.setTemp(jbData.getString("hightemp"));
            weatherBean.setWD(jbData.getString("fengxiang"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherBean;

    }
}
