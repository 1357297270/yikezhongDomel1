package com.example.administrator.yikezhongdomel.fragment.recom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.AttentionFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.frag.HotFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * data;2018/7/6
 * author:任志军
 */

public class RecomFragment extends Fragment{
    private TabLayout myTab;
    private ViewPager viewPager;
    private List<String> meuns;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.recomment, container, false );
        myTab = view.findViewById(R.id.myTab);
        viewPager = view.findViewById(R.id.vp);
        initMenus();
        MyAdapter myAdapter = new MyAdapter( getChildFragmentManager() );
        viewPager.setAdapter( myAdapter );
        viewPager.setOffscreenPageLimit( meuns.size() );
        myTab.setupWithViewPager( viewPager );

        return view;
    }

    private void initMenus() {
        meuns = new ArrayList<>();
        meuns.add("热门");
        meuns.add("关注");

    }
    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            if (position==0){
                HotFragment hotFragment = new HotFragment();
                return hotFragment;
            }else {
                AttentionFragment attentionFragment = new AttentionFragment();
                return attentionFragment;
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
