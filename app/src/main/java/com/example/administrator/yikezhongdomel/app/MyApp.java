package com.example.administrator.yikezhongdomel.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * data;2018/7/8
 * author:任志军
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize( this );
    }
}
