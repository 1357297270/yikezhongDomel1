package com.example.cela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        Button btnClose= (Button) findViewById(R.id.btnclose);
        Button btnOpen= (Button) findViewById(R.id.btnopen);
        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //此行代码即可完成侧滑菜单的显示与隐藏 true或false都是一样的效果
//                boolean isshow=menu.isMenuShowing();
                menu.showMenu(true);
            }
        });


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
        menu.setFadeDegree(0.35f);
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
}
