package com.example.administrator.yikezhongdomel.fragment.video.frag;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.video.adapter.VideoMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.video.model.VideoBean;
import com.example.administrator.yikezhongdomel.fragment.video.view.VideoDetails;
import com.example.administrator.yikezhongdomel.mylister.ApiService;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * data;2018/7/13
 * author:任志军
 */

public class VideoHotFragment extends Fragment {
    private RecyclerView mrecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.videohotment, container, false );
        mrecyclerView = view.findViewById( R.id.recycle1 );
        initVideoData();
        return view;
    }
    private void initVideoData() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.URL_IMG ).build();
        ApiService apiService = retrofit.create( ApiService.class );
        Call<ResponseBody> funnyrecycle = apiService.getVioderecycle();
        funnyrecycle.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    VideoBean videoBean = gson.fromJson( str, VideoBean.class );
                    List<VideoBean.DataBean> data = videoBean.getData();
                    mrecyclerView.setLayoutManager( new StaggeredGridLayoutManager( 2, StaggeredGridLayoutManager.VERTICAL ) );
                    VideoMyAdapter videoMyAdapter = new VideoMyAdapter( data, getActivity() );
                    mrecyclerView.setAdapter( videoMyAdapter );

                    //添加Android自带的分割线
                  mrecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
               videoMyAdapter.setOnItemClick( new VideoMyAdapter.OnItemClick() {
                   @Override
                   public void onImageClick(View view,int position) {
                       Toast.makeText( getActivity(), "s"+position, Toast.LENGTH_SHORT ).show();
                       Intent intent = new Intent( getActivity(), VideoDetails.class );
                       startActivity( intent );
                   }


               } );


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
