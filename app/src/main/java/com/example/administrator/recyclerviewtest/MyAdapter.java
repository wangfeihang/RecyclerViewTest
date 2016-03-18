package com.example.administrator.recyclerviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

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

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<HashMap>  myDataset,Context c1) {
        this(myDataset,c1, null, null);
    }
    public MyAdapter(ArrayList<HashMap>  myDataset,Context c1, OnItemClickListener onClickListener) {
        this(myDataset,c1, onClickListener, null);
    }
    public MyAdapter(ArrayList<HashMap>  myDataset,Context c1, OnItemClickListener onClickListener,
                     OnItemLongClickListener onLongClickListener) {
        mDataset = myDataset;
        mcontext = c1;
        this.onClickListener = onClickListener;
        this.onLongClickListener = onLongClickListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v, onClickListener,
                onLongClickListener);


        return vh;
    }





    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        View v=holder.v;
        TextView tv1=(TextView)v.findViewById(R.id.tv1);
        tv1.setText((String)mDataset.get(position).get("1"));
        TextView tv2=(TextView)v.findViewById(R.id.tv2);
        tv2.setText((String)mDataset.get(position).get("2"));
        TextView tv3=(TextView)v.findViewById(R.id.tv3);
        tv3.setText((String) mDataset.get(position).get("3"));
        TextView tv4=(TextView)v.findViewById(R.id.tv4);
        tv4.setText((String) mDataset.get(position).get("4"));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }



}