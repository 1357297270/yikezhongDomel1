package com.example.bug;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
    }
    //下标越界
    public void bug(){
        int[] ints = new int[3];
        System.out.print(ints[5] );
    }
}
