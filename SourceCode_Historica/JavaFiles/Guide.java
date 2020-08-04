package com.kay.historica;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;


public class Guide extends AppCompatActivity {
WebView webView;
ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tripobot);
        progressBar=(ProgressBar)findViewById(R.id.pb);
        Sprite chasingDots = new DoubleBounce();
        progressBar.setIndeterminateDrawable(chasingDots);
        webView=(WebView)findViewById(R.id.webView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setDomStorageEnabled(true);
        webSettings.setLoadWithOverviewMode(true);
        webSettings.setUseWideViewPort(true);
        webSettings.getDomStorageEnabled();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.incredibleindia.org/content/incredible-india-v2/en/destinations.html");
        webView.setWebViewClient(new WebViewClient());
        webView.setWebViewClient(new WebViewClient(){
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                webView.loadUrl("file:///android_asset/noint.png");

            }
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

                String javaScript ="javascript:(function() { var a =document.getElementsByClassName('section footer footer-nav-section pt-5');a[0].hidden='true';var b =document.getElementsByClassName('container');b[0].remove();var c=document.getElementsByClassName('col-lg-3');c[0].remove();var d =document.getElementsByClassName('container');d[16].remove();var e=document.getElementById('pop-over');e.remove();var f =document.getElementsByClassName('section no-title brand-section pb-5');f[0].remove();var g =document.getElementsByClassName('row');g[22].hidden ='true';})()";
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
