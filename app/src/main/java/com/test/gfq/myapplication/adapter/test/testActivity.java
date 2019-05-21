package com.test.gfq.myapplication.adapter.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.test.gfq.myapplication.bean.BagItemInfo;

import java.util.ArrayList;

public class testActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayList< BagItemInfo > list = new ArrayList<>();
       // TestAdapter adapter = new TestAdapter(list);

    }
}
