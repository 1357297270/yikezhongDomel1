package com.example.administrator.yikezhongdomel.fragment.video.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;

/**
 * data;2018/7/13
 * author:任志军
 */

public class VideoNearbyFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.videonearbyment, container, false );
        return view;
    }
}
