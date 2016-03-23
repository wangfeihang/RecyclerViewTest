package com.example.administrator.recyclerviewtest;

/**
 * Created by Administrator on 2016/3/23.
 */
public class SingleDayWeatherBean {
    private String errNum;
    private String errMsg;
    private SingleDayReturnData retData;

    public String getErrNum() {
        return errNum;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public SingleDayReturnData getRetData() {
        return retData;
    }

    public void setErrNum(String errNum) {
        this.errNum = errNum;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setRetData(SingleDayReturnData retData) {
        this.retData = retData;
    }
}
