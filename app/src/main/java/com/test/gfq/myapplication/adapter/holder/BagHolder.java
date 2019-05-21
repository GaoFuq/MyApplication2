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
   /* private SparseArray<View> mViews;//稀松数组，更节省内存
    private View mConvertView;

    public static BagHolder get(ViewGroup parent, int layoutResId){
        View convertView = LayoutInflater.from(parent.getContext()).inflate(layoutResId, parent, false);
        return new BagHolder(convertView);
    }
    public <T extends View> T getView(int id){
        View v = mViews.get(id);
        if(v == null){
            v = mConvertView.findViewById(id);
            //把item布局里面的所有控件放入稀松数组中进行缓存
            mViews.put(id, v);
        }
        return (T)v;
    }*/

}
