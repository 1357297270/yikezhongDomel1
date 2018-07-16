package com.example.mvprecycle.model;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.mvprecycle.OnNetListener;
import com.example.mvprecycle.adapter.MyAdapter;
import com.example.mvprecycle.bean.ReaBean;
import com.example.mvprecycle.constent.Constent;
import com.example.mvprecycle.getInterface;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * data;2018/7/12
 * author:任志军
 */

public class ReaModel {
    private Handler handler = new Handler(  );
    //type=3&page=1
    public void showData(final OnNetListener onNetListener){
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Constent.URL_BASE ).addConverterFactory( GsonConverterFactory.create() ).build();
        getInterface getInterface = retrofit.create( getInterface.class );
        Call<ResponseBody> lastData = getInterface.getLastData();
        lastData.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    final String string = response.body().string();
                    handler.post( new Runnable() {
                        @Override
                        public void run() {
                            onNetListener.onSuccess( string );
                        }
                    } );

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, final Throwable t) {
                handler.post( new Runnable() {
                    @Override
                    public void run() {
                        Log.e( "RZJ", "onFailure: "+t  );
                    }
                } );
            }
        } );
    }
}
