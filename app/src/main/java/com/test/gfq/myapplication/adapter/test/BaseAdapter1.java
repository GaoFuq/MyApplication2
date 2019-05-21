package com.test.gfq.myapplication.adapter.test;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.gfq.myapplication.MyInterface.OnRvItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public abstract class BaseAdapter1<T> extends RecyclerView.Adapter<BaseHolder> {


    private Context mContext;
    private LayoutInflater mInflater;
    private List<T> mDataList = new ArrayList<>();

    public BaseAdapter1(Context context) {
        mContext = context;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(getLayoutId(), parent, false);
        return new BaseHolder(itemView);
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, final int position) {
        onBindItemHolder(holder, position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnRvItemClickListener!=null){
                    mOnRvItemClickListener.onItemClick(v,position,getDataList().get(position));
                }
            }
        });
    }

    //局部刷新关键：带payload的这个onBindViewHolder方法必须实现
    @Override
    public void onBindViewHolder(BaseHolder holder, int position, List<Object> payloads) {
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, position);
        } else {
            onBindItemHolder(holder, position, payloads);
        }

    }

    public abstract int getLayoutId();

    public abstract void onBindItemHolder(BaseHolder holder, int position);

    public void onBindItemHolder(BaseHolder holder, int position, List<Object> payloads){

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public List<T> getDataList() {
        return mDataList;
    }

    public void setDataList(Collection<T> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void remove(int position) {
        this.mDataList.remove(position);
        notifyItemRemoved(position);

        if(position != (getDataList().size())){ // 如果移除的是最后一个，忽略
            notifyItemRangeChanged(position,this.mDataList.size()-position);
        }
    }

    public void clear() {
        mDataList.clear();
        Log.d("ListNewAdapter","clear");
        notifyDataSetChanged();
    }

    public   interface  OnItemClickListener<T>{
        void OnItemClick(View itemView, int position, T t);
    }
    private OnRvItemClickListener mOnRvItemClickListener;

    public void setOnRvItemClickListener(OnRvItemClickListener<T> mOnRvItemClickListener) {
       this. mOnRvItemClickListener = mOnRvItemClickListener;
    }
    /*
    protected Context mContext;
    protected int mScreenWidth;
    public void setScreenWidth(int width) {
        mSc reenWidth = width;
    }

    protected List<T> mDataList = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(Collection<T> list) {
        this.mDataList.clear();
        this.mDataList.addAll(list);
        notifyDataSetChanged();
    }

    public void addAll(Collection<T> list) {
        int lastIndex = this.mDataList.size();
        if (this.mDataList.addAll(list)) {
            notifyItemRangeInserted(lastIndex, list.size());
        }
    }

    public void clear() {
        mDataList.clear();
        notifyDataSetChanged();
    }

    public List<T> getDataList() {
        return mDataList;
    }*/
}
