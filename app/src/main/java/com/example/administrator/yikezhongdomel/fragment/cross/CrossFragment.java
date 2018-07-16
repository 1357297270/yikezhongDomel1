package com.example.administrator.yikezhongdomel.fragment.cross;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.cross.adapter.CrossMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.cross.model.CrossBean;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.AttentionFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.HotFragment;
import com.example.administrator.yikezhongdomel.mylister.ApiService;
import com.google.gson.Gson;

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

public class CrossFragment extends Fragment {


    private RecyclerView mrecyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.crossment, container, false );
        mrecyclerView = view.findViewById( R.id.recy );
        initCrossData();
        return view;
    }

    private void initCrossData() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl( Api.URL_IMG ).build();
        ApiService apiService = retrofit.create( ApiService.class );
        Call<ResponseBody> crossrecycle = apiService.getCrossrecycle();
        crossrecycle.enqueue( new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String str = response.body().string();
                    Gson gson = new Gson();
                    CrossBean crossBean = gson.fromJson( str, CrossBean.class );
                    List<CrossBean.DataBean> data = crossBean.getData();
                    mrecyclerView.setLayoutManager( new LinearLayoutManager( getActivity(), LinearLayoutManager.VERTICAL, false) );
                    CrossMyAdapter crossMyAdapter = new CrossMyAdapter( data,getActivity());
                    mrecyclerView.setAdapter( crossMyAdapter );

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