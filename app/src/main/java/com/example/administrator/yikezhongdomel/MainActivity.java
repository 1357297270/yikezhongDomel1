package com.example.administrator.yikezhongdomel;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.administrator.yikezhongdomel.fragment.cross.CrossFragment;
import com.example.administrator.yikezhongdomel.fragment.funny.FunnyFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.RecomFragment;
import com.example.administrator.yikezhongdomel.fragment.recom.view.WorkActivity;
import com.example.administrator.yikezhongdomel.fragment.video.VideoFragment;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout mFragment;
    /**
     * 推荐
     */
    private RadioButton mRecom;
    /**
     * 段子
     */
    private RadioButton mCross;
    /**
     * 视频
     */
    private RadioButton mVideo;
    /**
     * 趣图
     */
    private RadioButton mFunny;
    private RadioGroup mGroup;
    private SimpleDraweeView mMyImageView;
    /**
     * 推荐
     */
    private TextView mTitle;
    private ImageView mImageView;
    private SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        requestWindowFeature( Window.FEATURE_NO_TITLE );
        setContentView( R.layout.activity_main );
        initView();
        inidimg();
        //创建对象
        menu = new SlidingMenu(this);
        //设置出现的方式
        menu.setMode(SlidingMenu.LEFT);
        //设置触摸屏幕的模式
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        //设置阴影渐变的宽度
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.color.colorAccent);

        //设置滑动菜单视图的宽度
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        //设置渐入渐出的效果的值
        menu.setFadeDegree(0.25f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);

        //为侧滑菜单设置布局
//       menu.setMenu(R.layout.menu_left);

        View v = View.inflate(this, R.layout.item, null);

        ListView lv = (ListView) v.findViewById(R.id.lv);

       ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new String[]{"菜单一", "菜单二", "菜单三"});
        lv.setAdapter(adapter);
        //为侧滑菜单设置布局-可以使用自定义的view
        menu.setMenu(v);

    }

    private void inidimg() {
        if (mRecom.isChecked()) {
            Drawable recommendDrawable = getResources().getDrawable( R.drawable.raw_1500085367 );
            recommendDrawable.setBounds( 0, 5, 50, 55 );
            mRecom.setCompoundDrawables( null, recommendDrawable, null, null );
            mRecom.setTextColor( Color.parseColor( "#03A9F4" ) );
        } else {
            Drawable recommendDrawable0 = getResources().getDrawable( R.drawable.raw_1500083878 );
            recommendDrawable0.setBounds( 0, 5, 50, 55 );
            mRecom.setCompoundDrawables( null, recommendDrawable0, null, null );
            mRecom.setTextColor( Color.parseColor( "#101010" ) );
        }

        if (mCross.isChecked()) {
            Drawable recommendDrawable2 = getResources().getDrawable( R.drawable.raw_1500085899 );
            recommendDrawable2.setBounds( 0, 5, 50, 55 );
            mCross.setCompoundDrawables( null, recommendDrawable2, null, null );
            mCross.setTextColor( Color.parseColor( "#03A9F4" ) );
        } else {

            Drawable recommendDrawable02 = getResources().getDrawable( R.drawable.raw_1500085327 );
            recommendDrawable02.setBounds( 0, 5, 50, 55 );
            mCross.setCompoundDrawables( null, recommendDrawable02, null, null );
            mCross.setTextColor( Color.parseColor( "#101010" ) );
        }
        if (mVideo.isChecked()) {
            Drawable recommendDrawable3 = getResources().getDrawable( R.drawable.raw_1500086067 );
            recommendDrawable3.setBounds( 0, 5, 50, 55 );
            mVideo.setCompoundDrawables( null, recommendDrawable3, null, null );
            mVideo.setTextColor( Color.parseColor( "#03A9F4" ) );
        } else {
            Drawable recommendDrawable03 = getResources().getDrawable( R.drawable.raw_1500083686 );
            recommendDrawable03.setBounds( 0, 5, 50, 55 );
            mVideo.setCompoundDrawables( null, recommendDrawable03, null, null );
            mVideo.setTextColor( Color.parseColor( "#101010" ) );
        }


        if (mFunny.isChecked()) {
            Drawable recommendDrawable4 = getResources().getDrawable( R.drawable.pic2 );
            recommendDrawable4.setBounds( 0, 5, 50, 55 );
            mFunny.setCompoundDrawables( null, recommendDrawable4, null, null );
            mFunny.setTextColor( Color.parseColor( "#03A9F4" ) );
        } else {
            Drawable recommendDrawable04 = getResources().getDrawable( R.drawable.pic );
            recommendDrawable04.setBounds( 0, 5, 50, 55 );
            mFunny.setCompoundDrawables( null, recommendDrawable04, null, null );
            mFunny.setTextColor( Color.parseColor( "#101010" ) );
        }

    }

    private void initView() {
        mFragment = (FrameLayout) findViewById( R.id.fragment );
        mRecom = (RadioButton) findViewById( R.id.recom );
        mCross = (RadioButton) findViewById( R.id.cross );
        mVideo = (RadioButton) findViewById( R.id.video );
        mFunny = (RadioButton) findViewById( R.id.funny );
        mGroup = (RadioGroup) findViewById( R.id.group );

        mGroup.setOnCheckedChangeListener( this );
        inidimg();
        getSupportFragmentManager().beginTransaction().replace( R.id.fragment, new RecomFragment() ).commit();
        mMyImageView = (SimpleDraweeView) findViewById( R.id.my_image_view );
        //侧拉菜单
        mMyImageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.showMenu(true);
            }
        } );
        mTitle = (TextView) findViewById( R.id.title );
        mImageView = (ImageView) findViewById( R.id.imageView );
        //创作
        mImageView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, WorkActivity.class );
                startActivity( intent );
            }
        } );
    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.recom:
                inidimg();
                mTitle.setText(mRecom.getText().toString());
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment, new RecomFragment() ).commit();
                break;
            case R.id.cross:
                inidimg();
                mTitle.setText(mCross.getText().toString());
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment, new CrossFragment() ).commit();
                break;
            case R.id.video:

                getSupportFragmentManager().beginTransaction().replace( R.id.fragment, new VideoFragment() ).commit();
                inidimg();
                mTitle.setText(mVideo.getText().toString()  );
                break;
            case R.id.funny:
                inidimg();
                mTitle.setText(mFunny.getText().toString()  );
                getSupportFragmentManager().beginTransaction().replace( R.id.fragment, new FunnyFragment() ).commit();
                break;
        }
    }
}
