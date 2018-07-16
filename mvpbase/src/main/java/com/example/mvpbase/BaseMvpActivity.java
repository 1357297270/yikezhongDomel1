package com.example.mvpbase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public abstract class BaseMvpActivity <V,T extends BasePresenter<V>> extends IActivity {
    public T presenter ;

    public abstract T initPresenter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_base_mvp );
        presenter = initPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.attach( (V) this );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }
}
