package com.example.administrator.recyclerviewtest;

import java.util.List;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ReturnData {
    private String city;
    private String cityid;
    private FHBean  today;
    private List<FHBean> forecast;
    private List<FHBean> history;

    public void setCity(String city) {
        this.city = city;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public void setToday(FHBean today) {
        this.today = today;
    }

    public void setForecast(List<FHBean> forecast) {
        this.forecast = forecast;
    }

    public void setHistory(List<FHBean> history) {
        this.history = history;
    }

    public String getCity() {
        return city;
    }

    public String getCityid() {
        return cityid;
    }

    public FHBean getToday() {
        return today;
    }

    public List<FHBean> getForecast() {
        return forecast;
    }

    public List<FHBean> getHistory() {
        return history;
    }
}
