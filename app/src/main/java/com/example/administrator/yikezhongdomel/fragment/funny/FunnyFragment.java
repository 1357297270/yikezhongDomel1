package com.example.administrator.yikezhongdomel.fragment.funny;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.funny.adapter.FunnyMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.funny.model.FunnyBean;
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
 * data;2018/7/6
 * author:任志军
 */

public class FunnyFragment extends Fragment{
    private RecyclerView mrecyclerView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.funnyment, container, false );
        mrecyclerView = view.findViewById( R.id.recycle1 );
        initFunnyData();
        return view;
    }

    private void initFunnyData() {

    }
}
