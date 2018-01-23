package com.staefe.whus.whus_app_1_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class FindLocActivity extends AppCompatActivity {
    Button whusbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inplay);

        WebView htmlWebView = findViewById(R.id.webView1);
        htmlWebView.setWebViewClient(new CustomWebViewClient());
        WebSettings webSetting = htmlWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setDisplayZoomControls(true);
        htmlWebView.loadUrl("https://www.williamhill.us/find-a-location/");

        whusbar = findViewById(R.id.whusbar);
        whusbar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent myIntent = new Intent(FindLocActivity.this,
                        MainActivity.class);
                startActivity(myIntent);
            }
        });
    }


    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }
    }
}
