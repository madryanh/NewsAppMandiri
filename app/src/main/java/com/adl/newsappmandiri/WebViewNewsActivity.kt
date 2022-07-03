package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsappmandiri.model.ArticlesItemApple
import com.adl.newsappmandiri.model.ArticlesItemWallStreet

class WebViewNewsActivity : AppCompatActivity() {
    var data = ArticlesItemWallStreet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_news)

        val myWebView: WebView = findViewById(R.id.webView)
        if(intent.hasExtra("data")) {
            data = intent.getParcelableExtra("data")!!
            data.url?.let { myWebView.loadUrl(it) }
        }
    }
}