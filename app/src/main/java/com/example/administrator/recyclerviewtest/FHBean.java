package com.example.administrator.recyclerviewtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/3/22.
 */
public class FHBean {
        private String date;
        private String week;
        private String fengxiang;
        private String fengli;
        @SerializedName("hightemp")
        private String highTemp;
        @SerializedName("lowtemp")
        private String lowTemp;
        private String type;

        public String getDate() {
                return date;
        }

        public String getWeek() {
                return week;
        }

        public String getFengxiang() {
                return fengxiang;
        }

        public String getFengli() {
                return fengli;
        }

        public String getHighTemp() {
                return highTemp;
        }

        public String getLowTemp() {
                return lowTemp;
        }

        public String getType() {
                return type;
        }

        public void setDate(String date) {
                this.date = date;
        }

        public void setWeek(String week) {
                this.week = week;
        }

        public void setFengxiang(String fengxiang) {
                this.fengxiang = fengxiang;
        }

        public void setFengli(String fengli) {
                this.fengli = fengli;
        }

        public void setHighTemp(String highTemp) {
                this.highTemp = highTemp;
        }

        public void setLowTemp(String lowTemp) {
                this.lowTemp = lowTemp;
        }

        public void setType(String type) {
                this.type = type;
        }
}
