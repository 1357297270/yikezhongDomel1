package com.example.administrator.yikezhongdomel.fragment.recom.frag;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.recom.GlideImageLoader;
import com.example.administrator.yikezhongdomel.fragment.recom.adapter.HotAdapter;
import com.example.administrator.yikezhongdomel.fragment.recom.model.HotRecycle;
import com.example.administrator.yikezhongdomel.fragment.recom.model.ImgBean;
import com.example.administrator.yikezhongdomel.mylister.ApiService;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * data;2018/7/6
 * author:任志军
 */

public class HotFragment extends Fragment {
    private View view;
    private Banner mBanner;
    private RecyclerView mRecycle;
    private List<ImgBean.DataBean> data;
    private ArrayList<String> title;
    private ArrayList<String> list;
    private Handler handler=new Handler(  ){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            List<HotRecycle.DataBean> data= (List<HotRecycle.DataBean>) msg.obj;
            mRecycle.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false) );
            HotAdapter hotAdapter = new HotAdapter( data, getActivity() );
            mRecycle.setAdapter( hotAdapter );
        }
    };
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.hotment, container, false );
        initView( view );
        initImg();
        hotData();
        return view;
    }

    private void hotData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.URL_IMG).build();
        ApiService apiService = retrofit.create( ApiService.class );
        final Call<ResponseBody> hotrecycle = apiService.getHotrecycle();
        hotrecycle.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    HotRecycle hotRecy = gson.fromJson( str, HotRecycle.class );
                    List<HotRecycle.DataBean> data = hotRecy.getData();
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

    private void initImg() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.URL_IMG ).build();
        ApiService apiService = retrofit.create( ApiService.class );
        Call<ResponseBody> lastimg = apiService.getLastimg();
        lastimg.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String string = response.body().string();
                    Gson gson = new Gson();
                    ImgBean imgBean = gson.fromJson( string, ImgBean.class );
                   data = imgBean.getData();
                    list = new ArrayList<>();
                   list.add( data.get( 0 ).getIcon() ) ;
                    list.add( data.get( 1 ).getIcon() ) ;
                    list.add( data.get( 2 ).getIcon() ) ;
                    list.add( data.get( 3 ).getIcon() ) ;
                    title = new ArrayList<>();
                    title.add( data.get( 0 ).getTitle() );
                    title.add( data.get( 1 ).getTitle() );
                    title.add( data.get( 2 ).getTitle() );
                    title.add( data.get( 3 ).getTitle() );
                    mBanner.setBannerStyle( BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE );
                    mBanner.setImageLoader(new GlideImageLoader());   //设置图片加载器
                   mBanner.setImages(list);//设置图片源
                    mBanner.setDelayTime(1500);//设置轮播事件，单位毫秒
                    mBanner.setBannerTitles( title );
                    mBanner.setBannerAnimation( Transformer.Accordion);//设置轮播动画，动画种类很多，有兴趣的去试试吧，我在这里用的是默认
                    mBanner.setIndicatorGravity( BannerConfig.CENTER);//设置指示器的位置
                    mBanner.start();//开始轮播，一定要调用此方法。

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        } );
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById( R.id.banner );
        mRecycle = (RecyclerView) view.findViewById( R.id.recycle );
    }
}
