package com.test.gfq.myapplication.activity;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.gfq.myapplication.R;
import com.test.gfq.myapplication.adapter.test.BaseAdapter1;
import com.test.gfq.myapplication.adapter.test.BaseHolder;
import com.test.gfq.myapplication.bean.BagItemInfo;

import java.util.ArrayList;

public class BagActivity extends BaseActivity {
    private TextView tv_close;
    private RecyclerView rv_bag_grid;
    private TextView iv_left_material_name;
    private TextView iv_left_material_description;
    private TextView iv_left_material_equip;
    private TextView iv_left_material_unload;
    private TextView iv_left_material_sell;
    private TextView iv_left_material_buy;
    private ImageView iv_left_material_img;
    private TextView tv_material_sell_price;
    private TextView tv_material_buy_price;

    BaseAdapter1<BagItemInfo> adapter;

    @Override
    public double setScaleW() {
        return 0.9;
    }

    @Override
    public double setScaleH() {
        return 0.9;
    }

    @Override
    public int getLayoutResId() {
        return R.layout.bag_dialog_activity;
    }


    @Override
    public void findViews() {
        tv_close = findViewById(R.id.tv_close);
        rv_bag_grid = findViewById(R.id.rv_bag_grid);
        iv_left_material_name = findViewById(R.id.iv_left_material_name);
        iv_left_material_description = findViewById(R.id.iv_left_material_description);
        iv_left_material_equip = findViewById(R.id.iv_left_material_equip);
        iv_left_material_unload = findViewById(R.id.iv_left_material_unload);
        iv_left_material_sell = findViewById(R.id.iv_left_material_sell);
        iv_left_material_buy = findViewById(R.id.iv_left_material_buy);
        iv_left_material_img = findViewById(R.id.iv_left_material_img);
        tv_material_sell_price = findViewById(R.id.tv_material_sell_price);
        tv_material_buy_price = findViewById(R.id.tv_material_buy_price);
    }

    @Override
    public void bindValues() {
        final ArrayList<BagItemInfo> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            BagItemInfo bagItemInfo = new BagItemInfo();
            bagItemInfo.setImgResId(R.drawable.baoshi1);
            bagItemInfo.setMaterial_name("宝石"+i);
            bagItemInfo.setMaterial_num(i);
            bagItemInfo.setMaterial_sell_price(200+i);
            bagItemInfo.setMaterial_buy_price(400+i);
            bagItemInfo.setMaterial_description("hhhhhhhhhhhhhhhhhhhhhhhhhh"+i);
            list.add(bagItemInfo);
        }

        adapter = new BaseAdapter1<BagItemInfo>(this) {
            @Override
            public int getLayoutId() {
                return R.layout.bag_grid_item;
            }

            @Override
            public void onBindItemHolder(BaseHolder holder, int position) {
                final BagItemInfo bagItemInfo =  getDataList().get(position);
                holder.setImageResource(R.id.iv_bag_grid_item_img,bagItemInfo.getImgResId());
                holder.setText(R.id.tv_bag_grid_item_num,bagItemInfo.getMaterial_num()+"");
                holder.getView(R.id.iv_bag_grid_item_img).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        toast("ddd");
                        iv_left_material_name.setText(bagItemInfo.getMaterial_name());
                        iv_left_material_description.setText(bagItemInfo.getMaterial_description());
                        tv_material_sell_price.setText("出售："+bagItemInfo.getMaterial_sell_price()+"银两");
                        tv_material_buy_price.setText("购买："+bagItemInfo.getMaterial_buy_price()+"银两");
                    }
                });
            }
        };

        rv_bag_grid.setAdapter(adapter);

        adapter.setDataList(list);//用来刷新时,重新设置数据
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);
        rv_bag_grid.setLayoutManager(layoutManager);
        rv_bag_grid.addItemDecoration( new DividerItemDecoration(this ,DividerItemDecoration.HORIZONTAL));  //设置分隔线
        rv_bag_grid.setItemAnimator( new DefaultItemAnimator());//设置增加或删除条目的动画
    }

    @Override
    public void setListeners() {

    }

}
