package com.example.bug;

import android.app.Application;

/**
 * data;2018/7/12
 * author:任志军
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler.getInstance().init( this );
    }
}
