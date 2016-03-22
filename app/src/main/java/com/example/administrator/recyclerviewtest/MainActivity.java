package com.example.administrator.recyclerviewtest;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    //private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<HashMap> weatherList;
    private String httpUrl = "http://apis.baidu.com/apistore/weatherservice/recentweathers";
    private String httpArg = "cityname=%E5%8C%97%E4%BA%AC&cityid=101010100";
    private RecyclerView.Adapter mAdapter;
    private Context mcontext =this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weatherList=new ArrayList<HashMap>();
        new Thread(runnable).start();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addItemDecoration(new ItemDivider(this,
                ItemDivider.VERTICAL_LIST));
        mAdapter = new MyAdapter(weatherList,mcontext,new MyAdapter.OnItemClickListener() {

            @Override

            public void onClick(View v) {
                TextView info = (TextView) v.findViewById(R.id.tv_date);
                Toast.makeText(getApplicationContext(), "单击" + info.getText(), Toast.LENGTH_LONG).show();
            }
        },new MyAdapter.OnItemLongClickListener() {

            @Override
            public void onLongClick(View v) {
                TextView info = (TextView) v.findViewById(R.id.tv_date);
                Toast.makeText(getApplicationContext(), "长按"+info.getText(), Toast.LENGTH_LONG).show();

            }
        });
        mRecyclerView.setAdapter(mAdapter);
}



    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String jasonString = data.getString("value");
            List<WeatherBean> weatherBeanList =JsonHelper.ParseRecentWeathersJson(jasonString);
            for(int i=0;i<weatherBeanList.size();i++)
            {
                HashMap<String , String> map = new HashMap<String , String>();
                map.put("date" , "日期："+ weatherBeanList.get(i).getDate());
                map.put("weather" , "天气："+ weatherBeanList.get(i).getWeather());
                map.put("temp" , "气温："+ weatherBeanList.get(i).getTemp());
                map.put("WD" , "风向："+ weatherBeanList.get(i).getWD());
                weatherList.add(map);
                mAdapter.notifyDataSetChanged();
            }


        }
    };

    //异步请求
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            // TODO: http request.
            httpUrl = httpUrl + "?" + httpArg;
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(httpUrl)
                    .header("apikey", "b7c0e80f7e2a8767a3886952c632ed79")
                    .build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {
                    e.printStackTrace();
                }
                @Override
                public void onResponse(Response response) throws IOException {
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }
                    Message msg = new Message();
                    Bundle data = new Bundle();
                    String result=response.body().string()+"";
                    data.putString("value",result);
                    msg.setData(data);
                    handler.sendMessage(msg);
                }
            });
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
