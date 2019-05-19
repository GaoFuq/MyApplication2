package com.test.gfq.myapplication.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.test.gfq.myapplication.MyInterface.OnRVItemClickListener;
import com.test.gfq.myapplication.bean.BagItemInfo;

import java.util.List;

public class BagAdapter extends BaseAdapter<BagItemInfo> {

    @Override
    public void setOnRVItemClickListener(OnRVItemClickListener onRVItemClickListener) {
        super.setOnRVItemClickListener(onRVItemClickListener);
    }

    public BagAdapter(List<BagItemInfo> datas) {
        super(datas);
    }

    @Override
    public int getLayoutId(int layoutResId) {
        return layoutResId;
    }

    @Override
    public BagItemInfo getOtherTypeData(int position) {
        return super.getOtherTypeData(position);
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int layoutResId) {
        return super.onCreateViewHolder(parent, layoutResId);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
       // super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return super.getItemCount();
    }

    @Override
    public void convert(final VH holder, BagItemInfo data, int position) {
      //  convert(holder, mDatas.get(position),position);
        //在OnBindViewHolder方法中对Item设置点击事件监听，并将事件传递给接口对象 在这里给Item添加响应事件
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // 获取点击的位置
                int pos = holder.getLayoutPosition();
                //  传递点击位置
               onRVItemClickListener.onItemClick(pos);
            }
        });
    }
}
