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
    public TextView tv_date;//日期
    public TextView tv_weather;//天气
    public TextView tv_temp;//气温
    public TextView tv_l_tmp; //最低气温
    public TextView tv_h_tmp; //最高气温
    public TextView tv_WD; 	 //风向
    public TextView tv_WS;  //风力



    public  Item(View v)
    {
        tv_date=(TextView)v.findViewById(R.id.tv_date);
        tv_weather=(TextView)v.findViewById(R.id.tv_weather);
        tv_temp=(TextView)v.findViewById(R.id.tv_temp);
        tv_WD=(TextView)v.findViewById(R.id.tv_WD);

    }
    public void setItemData(ArrayList<HashMap> mDataset,int position)
    {
        if(position<mDataset.size()) {
            tv_date.setText((String) mDataset.get(position).get("date"));
            tv_weather.setText((String) mDataset.get(position).get("weather"));
            tv_temp.setText((String) mDataset.get(position).get("temp"));
            tv_WD.setText((String) mDataset.get(position).get("WD"));
        }

    }
}
