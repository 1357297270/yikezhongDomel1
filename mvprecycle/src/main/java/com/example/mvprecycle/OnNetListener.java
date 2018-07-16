package com.example.mvprecycle;

/**
 * data;2018/7/12
 * author:任志军
 */

public interface OnNetListener {
    void onSuccess(String result);
    void onFailed(Throwable t);
}
