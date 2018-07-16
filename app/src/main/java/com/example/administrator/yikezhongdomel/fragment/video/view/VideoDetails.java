package com.example.administrator.yikezhongdomel.fragment.video.view;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.video.adapter.VideoMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.video.model.VideoBean;
import com.example.administrator.yikezhongdomel.fragment.video.model.VideoDetailsBean;
import com.example.administrator.yikezhongdomel.mylister.ApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VideoDetails extends AppCompatActivity {

    private JCVideoPlayer player;
private Handler handler=new Handler(  ){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage( msg );
        VideoDetailsBean.DataBean data = (VideoDetailsBean.DataBean) msg.obj;
        player.setUp( data.getVideoUrl(),data.getCreateTime() );


    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_video_details );
        player = findViewById( R.id.player );
        initVideoDetails();

    }

    private void initVideoDetails() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.URL_IMG ).build();
        ApiService apiService = retrofit.create( ApiService.class );
        Call<ResponseBody> funnyrecycle = apiService.getViodeDetaile();
        funnyrecycle.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    VideoDetailsBean videoDetailsBean = gson.fromJson( str, VideoDetailsBean.class );
                    VideoDetailsBean.DataBean data = videoDetailsBean.getData();

                    Message obtain = Message.obtain();
                    obtain.obj=data;
                    handler.sendMessage( obtain );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        } );
    }
}