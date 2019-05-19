package com.test.gfq.myapplication.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.test.gfq.myapplication.R;
import com.test.gfq.myapplication.adapter.holder.BagHolder;
import com.test.gfq.myapplication.bean.BagItemInfo;

import java.util.List;

public class BagAdapter1 extends RecyclerView.Adapter<BagHolder> {
    private List<BagItemInfo> list;
    private Context context;
    private String Material_name;
    public  BagAdapter1(Context c,List<BagItemInfo> list){
        this.list=list;
        context=c;
    }
    @Override
    public void onBindViewHolder(@NonNull BagHolder holder, int position, @NonNull List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }


    //加载item 的布局  创建ViewHolder实例
    @NonNull
    @Override
    public BagHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bag_grid_item,viewGroup,false);
        BagHolder holder = new BagHolder(view);
        return holder;

    }

    //对RecyclerView子项数据进行赋值
    @Override
    public void onBindViewHolder(@NonNull BagHolder bagHolder, final int position) {
        final BagItemInfo bagItemInfo = list.get(position);
        bagHolder.iv_bag_grid_item_img.setImageResource(bagItemInfo.getImgResId());
        bagHolder.tv_bag_grid_item_num.setText(bagItemInfo.getMaterial_name());
        bagHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,position+"",Toast.LENGTH_SHORT).show();
                Material_name = bagItemInfo.getMaterial_name();
                Log.d("Material_name",Material_name);

            }
        });
    }
    //返回子项个数
    @Override
    public int getItemCount() {
        return list.size();
    }


}
