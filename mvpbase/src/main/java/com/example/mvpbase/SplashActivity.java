package com.example.mvpbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends BaseMvpActivity<SplashView,SplashPresenter> {

    @Override
    public SplashPresenter initPresenter() {
        return new SplashPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_splash );

    }
}
