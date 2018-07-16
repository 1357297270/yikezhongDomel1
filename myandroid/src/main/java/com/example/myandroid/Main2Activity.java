package com.example.myandroid;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public abstract class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main2 );
    }
    public boolean hasPermission(String... permissions){
        for (String permission: permissions ){
            if (ContextCompat.checkSelfPermission( this,permission )!= PackageManager.PERMISSION_GRANTED){
                return true;
            }
        }
        return false;
    }
    public void requestPermission(int code,String...permissions){
        ActivityCompat.requestPermissions( this,permissions,code );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult( requestCode, permissions, grantResults );
        switch (requestCode){
            case Constents.CALL_PHONE:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    Toast.makeText( this, "权限没开", Toast.LENGTH_SHORT ).show();
                }
            break;
            case Constents.WRITE:
                if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    doCallPhone();
                }else {
                    Toast.makeText( this, "权限没开", Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }
    public void doCallPhone(){

    };
}






