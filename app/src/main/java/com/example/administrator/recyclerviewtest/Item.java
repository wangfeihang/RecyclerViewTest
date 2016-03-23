package com.example.administrator.recyclerviewtest;

/**
 * Created by Administrator on 2016/3/18.
 */

import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2016/3/18.
 */
public class Item {
    public TextView dateTv;//日期
    public TextView weatherTv;//天气
    public TextView highTempTv;//气温
    public TextView lTmpTv; //最低气温
    public TextView hTmpTv; //最高气温
    public TextView fengxiangTv; 	 //风向
    public TextView WSTv;  //风力



    public  Item(View v)
    {
        dateTv=(TextView)v.findViewById(R.id.tv_date);
        weatherTv=(TextView)v.findViewById(R.id.tv_weather);
        highTempTv=(TextView)v.findViewById(R.id.tv_hightemp);
        fengxiangTv=(TextView)v.findViewById(R.id.tv_fengxiang);

    }
    public void setItemData(ArrayList<HashMap> mDataset,int position)
    {
        if(position<mDataset.size()) {
            dateTv.setText((String) mDataset.get(position).get("date"));
            weatherTv.setText((String) mDataset.get(position).get("weather"));
            highTempTv.setText((String) mDataset.get(position).get("hightemp"));
            fengxiangTv.setText((String) mDataset.get(position).get("fengxiang"));


        }

    }
}
