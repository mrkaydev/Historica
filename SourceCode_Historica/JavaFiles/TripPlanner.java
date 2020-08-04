package com.kay.historica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;


import com.github.ybq.android.spinkit.sprite.Sprite;

import com.github.ybq.android.spinkit.style.ThreeBounce;

import es.dmoral.toasty.Toasty;


public class TripPlanner extends AppCompatActivity {
    WebView webView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_planner);
        progressBar = (ProgressBar) findViewById(R.id.pb);
        Sprite chasingDots = new ThreeBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        webView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        //


        webSettings.setAppCachePath(getApplicationContext().getFilesDir().getAbsolutePath() + "/cache");
        webSettings.setAppCacheEnabled(true);
        webSettings.getLoadsImagesAutomatically();
        webSettings.setDomStorageEnabled(true);
        webSettings.getDomStorageEnabled();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webView.loadUrl("https://www.triphobo.com/trip");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                webView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                progressBar.setVisibility(View.GONE);
                webView.setVisibility(View.VISIBLE);

                String javaScript = "javascript:(function() { var a =document.getElementsByClassName('head-content-w');a[0].remove();var b =document.getElementsByClassName('head-content');b[0].hidden='true';var c =document.getElementsByClassName('dont-know-dates');c[0].remove();var d =document.getElementsByClassName('as-table-cell align-r');d[0].remove();})()";
                webView.loadUrl(javaScript);

            }

        });

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();

        } else {
            super.onBackPressed();
        }
    }
}
