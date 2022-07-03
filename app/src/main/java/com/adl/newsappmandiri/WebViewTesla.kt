package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsappmandiri.model.ArticlesItemTesla
import com.adl.newsappmandiri.model.ArticlesItemWallStreet

class WebViewTesla : AppCompatActivity() {
    var dataTesla = ArticlesItemTesla()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_tesla)

        val myWebView: WebView = findViewById(R.id.webViewTesla)
        if(intent.hasExtra("dataTesla")) {
            dataTesla = intent.getParcelableExtra("dataTesla")!!
            dataTesla.url?.let { myWebView.loadUrl(it) }
        }
    }
}