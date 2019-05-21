package com.test.gfq.myapplication.MyInterface;

import android.view.View;

public interface OnRvItemClickListener<T> {
    void onItemClick(View view, int position,T t);
}
