package com.test.gfq.myapplication.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.test.gfq.myapplication.R;

public class BattleDialogActivity extends BaseDialogActivity{
    @Override
    public int setMyContentView(Context context, int layout_res_id) {
        return super.setMyContentView(context, R.layout.battle_dialog_activity);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    void findViews() {

    }

    @Override
    void bindValues() {

    }

    @Override
    void setListeners() {

    }
}
