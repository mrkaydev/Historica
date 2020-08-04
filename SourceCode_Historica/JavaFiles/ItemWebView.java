package com.kay.historica;

import android.graphics.Bitmap;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.CubeGrid;

public class ItemWebView extends AppCompatActivity {

    WebView myWebView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        progressBar = (ProgressBar)findViewById(R.id.pro);
        Sprite cubeGrid = new CubeGrid();
        progressBar.setIndeterminateDrawable(cubeGrid);
        myWebView = (WebView) findViewById(R.id.webView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        Bundle b = getIntent().getExtras();
        String id = b.getString("id");

        myWebView.loadUrl(id);
        myWebView.setWebViewClient(new WebViewClient());
        myWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
                myWebView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
                myWebView.setVisibility(View.VISIBLE);
                //
                String javaScript ="javascript:(function() { var a= document.getElementsByTagName('header');a[0].hidden='true';a=document.getElementsByClassName('page_body');a[0].style.padding='0px';var b=document.getElementsByClassName('timestamp-link');b[0].hidden='true';var c=document.getElementsByClassName('post-footer container');c[0].style.blockSize='0px';var d=document.getElementsByClassName('post-footer container');d[0].style.height='0px';var e=document.getElementsByClassName('bg-photo-container');e[0].remove();var f =document.getElementsByClassName('flat-icon-button ripple');f[0].remove();f[0].remove();var g=document.getElementsByClassName('comments');g[0].remove();var h =document.getElementsByClassName('hu-powered-by hu-a-center hu-mobile-powered-by hu-width-full hu-opacity-0');h[1].remove();var i =document.getElementsByClassName('hu-powered-by hu-a-center hu-mobile-powered-by hu-width-full hu-opacity-0');i[1].remove(); })()";
               myWebView.loadUrl(javaScript);
                setTitle(view.getTitle());


            }
        });
    }
}
