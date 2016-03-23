package com.example.administrator.recyclerviewtest;

import com.google.gson.Gson;

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
    public static SingleDayReturnData toSingleDayWeatherBean(String jsonString) {

        Gson gson=new Gson();
        SingleDayWeatherBean singleDayWeatherBean = gson.fromJson(jsonString, SingleDayWeatherBean.class);
        SingleDayReturnData singleDayReturnData = singleDayWeatherBean.getRetData();
        return singleDayReturnData;
    }

    /**
     * @param jsonString
     *            :多日获得的json字符串
     * @return 返回结果
     */
    public static List<FHBean> toRecentWeathersBean(String jsonString)
    {
        List<FHBean> weatherBeanList=new ArrayList<FHBean>();
        Gson gson=new Gson();
        RecentWeathersBean recentWeathersBean = gson.fromJson(jsonString, RecentWeathersBean.class);
        ReturnData returnData=recentWeathersBean.getReturnData();
        FHBean today=returnData.getToday();
        List<FHBean>  forecast=returnData.getForecast();
        List<FHBean> history=returnData.getHistory();
        for(int i=0;i<history.size();i++)
        {
            weatherBeanList.add(history.get(i));
        }
        weatherBeanList.add(today);
        for(int i=0;i<forecast.size();i++)
        {
            weatherBeanList.add(forecast.get(i));
        }
        return weatherBeanList;

    }
}
