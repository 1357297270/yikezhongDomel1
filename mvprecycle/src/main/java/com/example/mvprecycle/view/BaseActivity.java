package com.example.mvprecycle.view;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * data;2018/7/12
 * author:任志军
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate( savedInstanceState, persistentState );
        setContentView( initLayout() );
        initView();
        initData();
    }

    protected abstract void initData();

    protected abstract void initView();

    protected abstract int initLayout();
}
