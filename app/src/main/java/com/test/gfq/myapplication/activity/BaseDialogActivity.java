package com.test.gfq.myapplication.activity;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.WindowManager;

public abstract class BaseDialogActivity extends AppCompatActivity{
    private int screenW,screenH;
    private Context mContext;
    private int layout_res_id;
   // private LayoutInflater inflater;
    public BaseDialogActivity(){

    }

    public int setMyContentView(Context context,int  layout_res_id){
        mContext = context;
        return this.layout_res_id=layout_res_id;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation ==Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

            setContentView(setMyContentView(mContext,layout_res_id));


       DisplayMetrics metrics = getResources().getDisplayMetrics();
       screenW = metrics.widthPixels;
       screenH = metrics.heightPixels;
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = (int)(screenW*0.8);
        p.height = (int)(screenH*0.9);
        getWindow().setAttributes(p);

        //inflater = LayoutInflater.from(mContext);

        findViews();
        bindValues();
        setListeners();
    }

    abstract void findViews();

    abstract void bindValues();

    abstract void setListeners();


}
