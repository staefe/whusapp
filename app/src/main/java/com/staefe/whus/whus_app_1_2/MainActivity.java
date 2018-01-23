package com.staefe.whus.whus_app_1_2;

import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;


public class MainActivity extends AppCompatActivity  {

    Button inplay, downloadapp, findaloc;
    Uri apkurl = Uri.parse("https://www.williamhill.us/android-app-clean/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/whhoxton.ttf");

        findaloc = findViewById(R.id.findlocbutton);
        findaloc.setTypeface(font);
        findaloc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        FindLocActivity.class);
                startActivity(myIntent);
            }
        });

        downloadapp = findViewById(R.id.downloadapp);
        downloadapp.setTypeface(font);
        downloadapp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // FILL request object

                DownloadManager.Request request=new DownloadManager.Request(apkurl);
                request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_WIFI | DownloadManager.Request.NETWORK_MOBILE)
                        .setAllowedOverRoaming(false)
                        .setMimeType("application/vnd.android.package-archive")
                ;

                // ADD request to download manager
                DownloadManager dm=(DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
                long id = dm.enqueue(request);

                // CHECK request by id
                Cursor c = dm.query( new DownloadManager.Query().setFilterById(id) );
                if( c.moveToFirst() ){
                    int status = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
                    switch(status)
                    {
                        case DownloadManager.STATUS_PAUSED:
                            break;
                        case DownloadManager.STATUS_PENDING:
                            break;
                        case DownloadManager.STATUS_RUNNING:
                            break;
                        case DownloadManager.STATUS_SUCCESSFUL:
                            break;
                        case DownloadManager.STATUS_FAILED:
                            break;
                    }
                }







               /* DownloadManager manager = (DownloadManager) getApplication().getSystemService(Context.DOWNLOAD_SERVICE);
                */
               AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this, R.style.Theme_AppCompat_DayNight_Dialog_Alert).create();
                alertDialog.setTitle("BEGINNING DOWNLOAD...");
                alertDialog.setMessage("The William Hill Sports Book App is now downloading to your DOWNLOADS.");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
                /*
                DownloadManager.Request request = new DownloadManager.Request(apkurl);
                request.setTitle("William Hill Sports Book");
                request.setDescription("Downloading App...");
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);

                if (manager != null) {
                    manager.enqueue(request);
                }*/
            }
        });

        inplay = findViewById(R.id.inplay);
        inplay.setTypeface(font);
        inplay.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(MainActivity.this,
                        InplayActivity.class);
                startActivity(myIntent);
            }
        });

    }

}