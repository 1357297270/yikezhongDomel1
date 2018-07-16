package com.example.administrator.yikezhongdomel.fragment.video;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.constent.Api;
import com.example.administrator.yikezhongdomel.fragment.funny.adapter.FunnyMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.funny.model.FunnyBean;
import com.example.administrator.yikezhongdomel.fragment.recom.RecomFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.AttentionFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.HotFragment;
import com.example.administrator.yikezhongdomel.fragment.video.adapter.VideoMyAdapter;
import com.example.administrator.yikezhongdomel.fragment.video.frag.VideoHotFragment;
import com.example.administrator.yikezhongdomel.fragment.video.frag.VideoNearbyFragment;
import com.example.administrator.yikezhongdomel.fragment.video.model.VideoBean;
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

public class VideoFragment extends Fragment{
    private TabLayout myTab;
    private ViewPager viewPager;
    private List<String> meuns;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.videoment, container, false );
        myTab = view.findViewById(R.id.myTab);
        viewPager = view.findViewById(R.id.vp);
        initMenus();
        MyAdapterHot myAdapterHot = new MyAdapterHot( getChildFragmentManager() );
        viewPager.setAdapter( myAdapterHot );
        viewPager.setOffscreenPageLimit( meuns.size() );
        myTab.setupWithViewPager( viewPager );
        return view;
    }
    private void initMenus() {
        meuns = new ArrayList<>();
        meuns.add("热门");
        meuns.add("附近");

    }
    class MyAdapterHot extends FragmentPagerAdapter {
        public MyAdapterHot(FragmentManager fm) {
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                VideoHotFragment videoHotFragment = new VideoHotFragment();
                return videoHotFragment;
            } else {
                VideoNearbyFragment videoNearbyFragment = new VideoNearbyFragment();
                return videoNearbyFragment;
            }
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return meuns.get( position );
        }

        @Override
        public int getCount() {
            return meuns.size();
        }
    }


}
