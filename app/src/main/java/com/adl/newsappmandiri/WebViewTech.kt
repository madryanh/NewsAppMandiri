package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsappmandiri.model.ArticlesItemTech
import com.adl.newsappmandiri.model.ArticlesItemTesla

class WebViewTech : AppCompatActivity() {
    var dataTech = ArticlesItemTech()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view_tech)

        val myWebView: WebView = findViewById(R.id.webViewTech)
        if(intent.hasExtra("dataTech")) {
            dataTech = intent.getParcelableExtra("dataTech")!!
            dataTech.url?.let { myWebView.loadUrl(it) }
        }
    }
}