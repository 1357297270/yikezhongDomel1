package com.example.mvpbase;

/**
 * data;2018/7/6
 * author:任志军
 */
/*使用MVP的架构,同时参数为泛型
        * 解决:MVP最常见的,内存泄漏的问题*/
public abstract class BasePresenter<T> {

    public T view;
    public void attach(T view) {
        this.view = view;
    }
    //防止内存泄漏,将对象置为null
      public void detach(){
        this.view=null;
}
}
