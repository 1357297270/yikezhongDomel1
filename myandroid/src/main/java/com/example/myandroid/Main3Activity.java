package com.example.myandroid;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main3Activity extends Main2Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main3 );

    }
public void open(View view)
{
        callPhoneSix(  );
}
public void sdopen(View view){
    new Intent( this,Main4Activity.class );
}

    private void callPhoneSix() {
    if (hasPermission( Manifest.permission.CALL_PHONE )){
        requestPermission(  Constents.CALL_PHONE ,Manifest.permission.CALL_PHONE);
    }else {
        doCallPhone();
    }
    }
    @SuppressLint("MissingPermission")
    public void doCallPhone(){
        Intent intent = new Intent( Intent.ACTION_CALL );
        Uri parse = Uri.parse( "tel" + "15010366095" );
        intent.setData( parse );
        startActivity( intent );
    };
}
