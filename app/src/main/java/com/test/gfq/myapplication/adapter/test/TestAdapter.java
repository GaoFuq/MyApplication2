package com.test.gfq.myapplication.adapter.test;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.gfq.myapplication.R;
import com.test.gfq.myapplication.bean.BagItemInfo;

public class TestAdapter extends BaseAdapter1<BagItemInfo>{

    public TestAdapter(Context context) {
        super(context);
    }
    @Override
    public int getLayoutId() {
        return R.layout.bag_grid_item;
    }
    @Override
    public void onBindItemHolder(BaseHolder holder, int position) {
            BagItemInfo bagItemInfo = getDataList().get(position);
            ImageView img = holder.getView(R.id.iv_bag_grid_item_img);
            TextView tv = holder.getView(R.id.tv_bag_grid_item_num);
            tv.setText(bagItemInfo.getMaterial_num()+"");
            img.setImageResource(bagItemInfo.getImgResId());
    }

}