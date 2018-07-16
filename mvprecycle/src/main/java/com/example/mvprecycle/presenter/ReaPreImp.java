package com.example.mvprecycle.presenter;

import android.util.Log;

import com.example.mvprecycle.OnNetListener;
import com.example.mvprecycle.bean.ReaBean;
import com.example.mvprecycle.model.ReaModel;
import com.example.mvprecycle.view.ReaView;
import com.google.gson.Gson;

import java.util.List;

/**
 * data;2018/7/12
 * author:任志军
 */

public class ReaPreImp implements ReaPre{
    private ReaModel reaModel;
    private ReaView reaView;

    public ReaPreImp(ReaView reaView) {
        this.reaView = reaView;
        reaModel = new ReaModel();
    }

    @Override
    public void showData() {
        reaModel.showData(new OnNetListener() {
            @Override
            public void onSuccess(String result) {
                ReaBean reaBean = new Gson().fromJson( result, ReaBean.class );
                List<ReaBean.DataBean> data = reaBean.getData();
                reaView.showData( data );

            }

            @Override
            public void onFailed(Throwable t) {
                Log.e( "RZJ", "onFailed: "+t.toString()  );
            }
        } );
    }
}
