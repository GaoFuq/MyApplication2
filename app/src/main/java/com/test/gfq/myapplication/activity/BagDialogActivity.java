package com.test.gfq.myapplication.activity;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.gfq.myapplication.R;
import com.test.gfq.myapplication.adapter.BagAdapter1;
import com.test.gfq.myapplication.bean.BagItemInfo;

import java.util.ArrayList;

public class BagDialogActivity extends BaseDialogActivity implements View.OnClickListener {

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

    private String materialName;
    private int materialImgId;
    private String materialDescription;
    private int materialSellPrice;
    private int materialBuyPrice;
    private BagAdapter1 adapter;
    @Override
    public int setMyContentView(Context context, int layout_res_id) {
        return super.setMyContentView(context, R.layout.bag_dialog_activity);
    }


    @Override
    void findViews() {
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
  /*  private void bindOtherData(){
        iv_left_material_name.setText(materialName);
        iv_left_material_description.setText(materialDescription);
        tv_material_sell_price.setText("出售："+materialSellPrice+"银两");
        tv_material_buy_price.setText("购买："+materialBuyPrice+"银两");
        iv_left_material_img.setImageResource(materialImgId);
    }*/
    @Override
    void bindValues() {

        final ArrayList<BagItemInfo> list = new ArrayList<>();
        for(int i=0;i<20;i++){
            BagItemInfo bagItemInfo = new BagItemInfo();
            bagItemInfo.setImgResId(R.drawable.baoshi1);
            bagItemInfo.setMaterial_name("宝石"+i);
            bagItemInfo.setMaterial_num(i);
            bagItemInfo.setMaterial_sell_price(200);
            bagItemInfo.setMaterial_buy_price(400);
            bagItemInfo.setMaterial_description("hhhhhhhhhhhhhhhhhhhhhhhhhh");
            list.add(bagItemInfo);
        }
          /*   adapter = new BagAdapter(list) {
            @Override
            public int getLayoutId(int layoutResId) {
                return R.layout.bag_grid_item;
            }

            @Override
            public void convert(VH holder, final BagItemInfo data, final int position) {
               holder.setImgResId(R.drawable.baoshi1,R.id.iv_bag_grid_item_img).setOnClickListener(BagDialogActivity.this);
               holder.setText(data.getMaterial_num()+"",R.id.tv_bag_grid_item_num);
            }
        };*/

          adapter = new BagAdapter1(this,list);
        //实现接口，并重写方法，实现内容 给Adapter添加监听器
        //adapter.setOnRVItemClickListener(this);




        // LinearLayoutManager layoutManager = new LinearLayoutManager(this );//设置布局管理器

        // 竖直方向的网格布局管理器，每行四个Item
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);
        rv_bag_grid.setLayoutManager(layoutManager);

        //layoutManager.setOrientation(OrientationHelper. VERTICAL);//设置为垂直布局，这也是默认的.线型布局时使用

        rv_bag_grid.setAdapter(adapter);//设置Adapter

        rv_bag_grid.addItemDecoration( new DividerItemDecoration(this ,DividerItemDecoration.HORIZONTAL));  //设置分隔线

        rv_bag_grid.setItemAnimator( new DefaultItemAnimator());//设置增加或删除条目的动画



    }

  /*  @Override
    public void onItemClick(int pos) {
        Toast.makeText(this,"pos",Toast.LENGTH_SHORT).show();
    }*/

    @Override
    void setListeners() {
        tv_close.setOnClickListener(this);
        iv_left_material_equip.setOnClickListener(this);
        iv_left_material_unload.setOnClickListener(this);
        iv_left_material_sell.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_close:
                finish();
                break;
            default:
                break;
        }
    }

  /*
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"sssdd",Toast.LENGTH_SHORT).show();
        BagItemInfo bagItemInfo = (BagItemInfo)adapter.getOtherTypeData(position);
        materialName = bagItemInfo.getMaterial_name();
        materialImgId = bagItemInfo.getImgResId();
        materialDescription = bagItemInfo.getMaterial_description();
        materialSellPrice = bagItemInfo.getMaterial_sell_price();
        materialBuyPrice = bagItemInfo.getMaterial_buy_price();
        bindOtherData();
    }*/
}
