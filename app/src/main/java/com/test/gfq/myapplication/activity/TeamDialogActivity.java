package com.test.gfq.myapplication.activity;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.test.gfq.myapplication.R;

public class TeamDialogActivity extends BaseDialogActivity implements View.OnClickListener{

    private TextView tv_close;
    @Override
    public int setMyContentView(Context c,int  layout_res_id) {
        return super.setMyContentView(this,R.layout.team_dialog_activity);
    }

    @Override
    void findViews() {
        tv_close = findViewById(R.id.tv_close);

    }

    @Override
    void bindValues() {
     /*   LinearLayoutManager layoutManager = new LinearLayoutManager(this );
//设置布局管理器
        rv_team_info.setLayoutManager(layoutManager);
//设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper. VERTICAL);
//设置Adapter
        recyclerView.setAdapter(recycleAdapter);
        //设置分隔线
        recyclerView.addItemDecoration( new DividerGridItemDecoration(this ));
//设置增加或删除条目的动画
        recyclerView.setItemAnimator( new DefaultItemAnimator());*/
    }

    @Override
    void setListeners() {
        tv_close.setOnClickListener(this);
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
}
