package com.example.administrator.recyclerviewtest;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2016/3/22.
 */
public class RecentWeathersBean {
    private int errNum;
    private String  errMsg;
    @SerializedName("retData")
    private ReturnData returnData;
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setErrNum(int errNum) {
        this.errNum = errNum;
    }

    public void setReturnData(ReturnData returnData) {
        this.returnData = returnData;
    }


    public int getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public ReturnData getReturnData() {
        return returnData;
    }


    public RecentWeathersBean() {
    }
}
