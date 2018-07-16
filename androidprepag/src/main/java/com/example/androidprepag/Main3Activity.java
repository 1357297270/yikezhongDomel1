package com.example.androidprepag;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );
    }
    public void open(View view)
    {
        callPhoneSix(  );
    }


    private void callPhoneSix() {
        if (hasPermission( Manifest.permission.CALL_PHONE )){
            requestPermission(  Constents.CALL_PHON ,Manifest.permission.CALL_PHONE);
        }else {
            doCallPhone();
        }

    }

    @SuppressLint("MissingPermission")
    public void doCallPhone(){
        Intent intent = new Intent( Intent.ACTION_CALL );
        Uri parse = Uri.parse( "tel" + "110" );
        intent.setData( parse );
        startActivity( intent );
    };
}
