package com.example.administrator.yikezhongdomel.fragment.recom.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.yikezhongdomel.R;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * data;2018/7/6
 * author:任志军
 */

public class AttentionFragment extends Fragment {
    private View view;
    private SimpleDraweeView mMyImageView;
    private RecyclerView mRecycle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.attentionment, container, false );
        initView( view );
        return view;
    }

    private void initView(View view) {
        mMyImageView = (SimpleDraweeView) view.findViewById( R.id.my_image_view );
        mRecycle = (RecyclerView) view.findViewById( R.id.recycle );
    }
}
