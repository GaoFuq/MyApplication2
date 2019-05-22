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
import com.test.gfq.myapplication.adapter.test.BaseAdapter1;
import com.test.gfq.myapplication.adapter.test.BaseHolder;
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
   // private BagAdapter1 adapter;

    BaseAdapter1<BagItemInfo> adapter;
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
        //TODO 1.查询数据库的背包信息
        // TODO 2.取出来显示在背包界面

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


          //adapter = new BagAdapter1(this,list);
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
                        iv_left_material_name.setText(bagItemInfo.getMaterial_name());
                        iv_left_material_description.setText(bagItemInfo.getMaterial_description());
                        tv_material_sell_price.setText("出售："+bagItemInfo.getMaterial_sell_price()+"银两");
                        tv_material_buy_price.setText("购买："+bagItemInfo.getMaterial_buy_price()+"银两");
                    }
                });

            }


        };

        adapter.setDataList(list);//用来刷新时,重新设置数据

        // LinearLayoutManager layoutManager = new LinearLayoutManager(this );//设置布局管理器
        // 竖直方向的网格布局管理器，每行四个Item
        GridLayoutManager layoutManager = new GridLayoutManager(this, 4, OrientationHelper.VERTICAL, false);
        rv_bag_grid.setLayoutManager(layoutManager);

        //layoutManager.setOrientation(OrientationHelper. VERTICAL);//设置为垂直布局，这也是默认的.线型布局时使用

        rv_bag_grid.setAdapter(adapter);//设置Adapter

        rv_bag_grid.addItemDecoration( new DividerItemDecoration(this ,DividerItemDecoration.HORIZONTAL));  //设置分隔线

        rv_bag_grid.setItemAnimator( new DefaultItemAnimator());//设置增加或删除条目的动画


       /* adapter.setOnRvItemClickListener(new OnRvItemClickListener() {
            @Override
            public void onItemClick(View view, int position, Object o) {
                final BagItemInfo bagItemInfo = list.get(position);
                //Toast.makeText(BagDialogActivity.this,bagItemInfo.getMaterial_name(),Toast.LENGTH_SHORT).show();
                iv_left_material_name.setText(bagItemInfo.getMaterial_name());
                iv_left_material_description.setText(bagItemInfo.getMaterial_description());
                tv_material_sell_price.setText("出售："+bagItemInfo.getMaterial_sell_price()+"银两");
                tv_material_buy_price.setText("购买："+bagItemInfo.getMaterial_buy_price()+"银两");
            }
        });*/


    }

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
