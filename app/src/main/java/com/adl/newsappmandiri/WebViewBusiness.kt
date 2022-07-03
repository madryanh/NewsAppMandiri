package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsappmandiri.model.ArticlesItemBusines
import com.adl.newsappmandiri.model.ArticlesItemWallStreet

class WebViewBusiness : AppCompatActivity() {
    var dataBusiness = ArticlesItemBusines()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_business)

        val myWebView: WebView = findViewById(R.id.webViewWs)
        if(intent.hasExtra("dataBusiness")) {
            dataBusiness = intent.getParcelableExtra("dataBusiness")!!
            dataBusiness.url?.let { myWebView.loadUrl(it) }
        }
    }
}