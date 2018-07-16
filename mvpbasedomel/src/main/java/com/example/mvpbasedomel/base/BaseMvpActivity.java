package com.example.mvpbasedomel.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.BaseMenuPresenter;

import com.example.mvpbasedomel.R;

public abstract class BaseMvpActivity<V,T extends BasePresenter<V>> extends AppCompatActivity {
    public T presenter ;

    public abstract T initPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_base_mvp );
        presenter = initPresenter();
    }
    //绑定资源
    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach((V) this);
    }
    //释放资源
    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
