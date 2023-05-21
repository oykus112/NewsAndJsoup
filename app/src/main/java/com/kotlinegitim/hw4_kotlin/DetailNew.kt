package com.kotlinegitim.hw4_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class DetailNew : AppCompatActivity() {

    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_new)


        var url = intent.getStringExtra("href")

        webView = findViewById(R.id.webView)


        webView.webViewClient = WebViewClient()

        if (url != null) {
            webView.loadUrl(url)
        }

        webView.settings.javaScriptEnabled = true


        webView.settings.setSupportZoom(true)


    }
}

