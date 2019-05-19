package com.test.gfq.myapplication.adapter.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.gfq.myapplication.R;

public class BagHolder extends RecyclerView.ViewHolder {
    public ImageView iv_bag_grid_item_img;
    public TextView tv_bag_grid_item_num;
    public BagHolder(View view) {
        super(view);
        iv_bag_grid_item_img =  view.findViewById(R.id.iv_bag_grid_item_img);
        tv_bag_grid_item_num = view.findViewById(R.id.tv_bag_grid_item_num);
    }

}
