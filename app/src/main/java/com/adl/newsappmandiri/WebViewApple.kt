package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsappmandiri.model.ArticlesItemApple
import com.adl.newsappmandiri.model.ArticlesItemBusines

class WebViewApple : AppCompatActivity() {
    var dataApple = ArticlesItemApple()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_apple)

        val myWebView: WebView = findViewById(R.id.webViewApple)
        if(intent.hasExtra("dataApple")) {
            dataApple = intent.getParcelableExtra("dataApple")!!
            dataApple.url?.let { myWebView.loadUrl(it) }
        }
    }
}