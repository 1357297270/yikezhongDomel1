package com.example.update_domel;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * data;2018/7/16
 * author:任志军
 */

public class UpdateManager {
    private String PATH="";
    private Context mcontext;

    public UpdateManager(Context mcontext) {
        this.mcontext = mcontext;
    }
private static final int DOWNLOAD_FINISN=2;
    private String version_path;
    private String version_name;
    private String version_desc;
    private String version_code;
    @SuppressLint("HandlerLeak")
    private Handler handler=new Handler(  ){

        private AlertDialog malertDialog;
        private ProgressBar mProgtrssBar;
        private PackageInfo localversion1;

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage( msg );
            String text = (String) msg.obj;
            System.out.print( text );
            Gson gson = new Gson();
            Ver ver = gson.fromJson( text, Ver.class );
            System.out.print( ver.version_code );

            version_code = ver.version_code;
            version_desc = ver.version_desc;
            version_name = ver.version_name;
            version_path = ver.version_path;
            if (isUpdate()){
                Toast.makeText( mcontext, "需要更新", Toast.LENGTH_SHORT ).show();
              showNoticeDialog();
            }else {
                Toast.makeText( mcontext, "已经是最新版本", Toast.LENGTH_SHORT ).show();

            }


        }

        private void showNoticeDialog() {
            AlertDialog.Builder builder = new AlertDialog.Builder( mcontext );
            builder.setTitle( "提示" );
            String message="软件需要更新，安装\n"+version_desc;
            builder.setMessage( message );
            builder.setPositiveButton( "更新", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                 dialog.dismiss();
                    showDownloadDialog();
                }
            } );
            builder.setNegativeButton( "下次再说", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            } );
            builder.create().show();

        }
protected  void showDownloadDialog(){
    AlertDialog.Builder builder = new AlertDialog.Builder( mcontext );
    builder.setTitle( "下载中" );
  /*  View view = LayoutInflater.from( mcontext ).inflate( R.layout.diolog_progress, null );
    mProgtrssBar = view.findViewById( R.id.id_progress );
    builder.setView( view );*/
    builder.setNegativeButton( "取消", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.dismiss();
          //  mIsCancel=true;
        }
    } );
    malertDialog = builder.create();
    malertDialog.show();
     downloadAPK();
}

        private void downloadAPK() {
    new Thread( new Runnable() {
        @Override
        public void run() {

        }
    } ).start();
        }
protected void installAPK(){
    File file = new File( version_path, version_name );
    if (!file.exists()){
        return;
       /* Intent intent = new Intent( Intent.ACTION_VIEW );
        intent.setDataAndType( Uri.fromFile( file ),"" );
        mcontext.startActivity( intent );*/
    }
}
        protected boolean isUpdate() {
            int serverVersion = Integer.parseInt( version_code );
            int localversion=1;
            try {
                localversion1 = mcontext.getPackageManager().getPackageInfo( "", 0 );
                System.out.print( localversion1 );
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (serverVersion>localversion){
                return true;
            }else {
                return false;
            }


        }
    };
    public void checkUpdate(){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url( PATH )
                .build();


        Call call = okHttpClient.newCall( request );
        call.enqueue( new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String text = response.body().string();
                Message obtain = Message.obtain();
                obtain.obj=text;
                handler.sendMessage( obtain );
            }
        } );
    }

}
