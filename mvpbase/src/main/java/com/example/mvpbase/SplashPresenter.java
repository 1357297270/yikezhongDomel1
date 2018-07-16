package com.example.mvpbase;

/**
 * data;2018/7/6
 * author:任志军
 */

public class SplashPresenter extends BasePresenter<SplashView>{

    private  SplashModelImpl splashModel;

    public   SplashPresenter(){
        splashModel = new SplashModelImpl();
  }

}
