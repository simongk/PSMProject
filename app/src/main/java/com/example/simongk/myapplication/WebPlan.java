package com.example.simongk.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebPlan extends Activity {

    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webplan);
        mWebView=(WebView) findViewById(R.id.activity_main2_webview);
        WebSettings ws = mWebView.getSettings();
        ws.setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.mech.pk.edu.pl/~podzial/stacjonarne/html/index.html");
        Intent intent = getIntent();

    }

}
