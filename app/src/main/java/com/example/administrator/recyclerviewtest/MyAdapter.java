package com.example.administrator.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
   // private String[] mDataset;
    private ArrayList<HashMap> mDataset;
    private Context mcontext;
    interface OnItemClickListener {
        void onClick(View v);
    }
    interface OnItemLongClickListener {
        void onLongClick(View v);
    }
    private OnItemClickListener onClickListener;
    private OnItemLongClickListener onLongClickListener;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View v;
        public ViewHolder(View itemLayoutView,
                          final OnItemClickListener onClickListener,
                          final OnItemLongClickListener onLongClickListener) {
            super(itemLayoutView);
            v=itemLayoutView;
            itemLayoutView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if (onClickListener != null) {
                        onClickListener.onClick(v);
                    }
                }
            });
            itemLayoutView.setOnLongClickListener(new View.OnLongClickListener() {

                @Override
                public boolean onLongClick(View v) {
                    if (onLongClickListener != null) {
                        onLongClickListener.onLongClick(v);
                    }
                    return true;
                }
            });
        }

    }
    public void setd(String j) {
        HashMap<String , String> map = new HashMap<String , String>();
        map.put("date" , "日期："+j);
        map.put("weather" , "天气：");
        map.put("hightemp" , "气温：");
        map.put("fengxiang", "风向：" );
        mDataset.add(map);
    }
    public void setData(List<FHBean> dataSet){
        for(int i=0;i<dataSet.size();i++)
        {
            HashMap<String , String> map = new HashMap<String , String>();
            map.put("date" , "日期："+ dataSet.get(i).getDate());
            map.put("weather" , "天气："+ dataSet.get(i).getType());
            map.put("hightemp" , "气温："+ dataSet.get(i).getHighTemp());
            map.put("fengxiang", "风向：" + dataSet.get(i).getFengxiang());
            mDataset.add(map);
        }
    }
    public MyAdapter(Context mcontext) {
        this( null, null);
    }
    public MyAdapter(Context mcontext, OnItemClickListener onClickListener) {
        this(mcontext, onClickListener, null);
    }
    public MyAdapter(Context mcontext, OnItemClickListener onClickListener,
                     OnItemLongClickListener onLongClickListener) {
        mDataset=new ArrayList<HashMap>();
        this.mcontext = mcontext;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    // Create new views (invoked by the item manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        ViewHolder vh = new ViewHolder(v, onClickListener,
                onLongClickListener);
        return vh;
    }
    // Replace the contents of a view (invoked by the item manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        View v=holder.v;
        Item item=new Item(v);
        item.setItemData(mDataset,position);
    }
    // Return the size of your dataset (invoked by the item manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}