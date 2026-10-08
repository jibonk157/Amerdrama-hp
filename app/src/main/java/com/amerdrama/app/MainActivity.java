package com.amerdrama.app;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    private WebView webView;
    @Override public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(0xff0d0d16);
        getWindow().setNavigationBarColor(0xff1b1b29);
        webView = new WebView(this);
        webView.setBackgroundColor(0xff0d0d16);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }
    @Override public void onBackPressed() {
        webView.evaluateJavascript("if(!document.getElementById('player').classList.contains('hidden'))closePlayer();", null);
    }
    @Override protected void onDestroy() {
        webView.destroy();
        super.onDestroy();
    }
}
