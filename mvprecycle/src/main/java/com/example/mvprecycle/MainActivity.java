package com.example.mvprecycle;

import android.content.Context;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.mvprecycle.adapter.MyAdapter;
import com.example.mvprecycle.bean.ReaBean;
import com.example.mvprecycle.constent.Constent;
import com.example.mvprecycle.presenter.ReaPreImp;
import com.example.mvprecycle.view.BaseActivity;
import com.example.mvprecycle.view.ReaView;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements ReaView {

    private RecyclerView mRecycle;
    private ReaPreImp reaPreImp;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate( savedInstanceState, persistentState );
        setContentView( R.layout.activity_main );
        //mRecycle = (RecyclerView) findViewById( R.id.recycle );
     //   mRecycle.setLayoutManager( new LinearLayoutManager( this, LinearLayoutManager.VERTICAL, false ) );

        reaPreImp = new ReaPreImp( this );
        reaPreImp.showData();
    }

    @Override
    public void showData(List<ReaBean.DataBean> data) {
        Log.e( "RZJ", "showData: "+data.size()  );
        MyAdapter myAdapter = new MyAdapter( data, MainActivity.this );
       // mRecycle.setAdapter( myAdapter );
    }
}
