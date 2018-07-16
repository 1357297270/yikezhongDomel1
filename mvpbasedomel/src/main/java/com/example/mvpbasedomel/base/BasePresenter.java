package com.example.mvpbasedomel.base;

/**
 * data;2018/7/7
 * author:任志军
 */

public abstract class BasePresenter<T> {
    public T view;

    public void attach(T view) {
        this.view = view;
    }

    //防止内存泄漏,将对象置为null
    public void detach() {
        this.view = null;
    }
}
