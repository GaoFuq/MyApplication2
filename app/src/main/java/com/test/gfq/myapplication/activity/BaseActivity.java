package com.test.gfq.myapplication.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;

public abstract class BaseActivity extends AppCompatActivity {
    private static boolean isExit = false;
    private int screenW,screenH;
    private float scaleW,scaleH;
    private Context mContext;

    public AlertDialog mDailog;
    public BaseActivity(){

    }

    public BaseActivity(Context mContext,int scaleW,int scaleH){
       this.mContext = mContext;
       this.scaleW = scaleW;
       this.scaleH = scaleH;
    }
    @SuppressLint("HandlerLeak")
    static Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            isExit = false;
        }
    };
    public abstract int getLayoutResId();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }

        setContentView(getLayoutResId());

        DisplayMetrics metrics = getResources().getDisplayMetrics();
        screenW = metrics.widthPixels;
        screenH = metrics.heightPixels;
        WindowManager.LayoutParams p = getWindow().getAttributes();
        p.width = (int)(screenW*scaleW);
        p.height = (int)(screenH*scaleH);
        getWindow().setAttributes(p);



        findViews();
        bindValues();
        setListeners();
    }

    abstract void findViews();

    abstract void bindValues();

    abstract void setListeners();

    public void toast(String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_SHORT).show();
    }


























    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    private void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(0, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }



}
