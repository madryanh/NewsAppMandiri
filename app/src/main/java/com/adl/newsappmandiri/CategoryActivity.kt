package com.adl.newsappmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_category.*
import kotlinx.android.synthetic.main.news_tesla.*

class CategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        cardCatApple.setOnClickListener({
            val intent = Intent(this@CategoryActivity, MainActivity::class.java)
            startActivity(intent)
        })

        cardCalBusiness.setOnClickListener({
            val intent = Intent(this@CategoryActivity, TopBusinessActivity::class.java)
            startActivity(intent)
        })

        cardCatTech.setOnClickListener({
            val intent = Intent(this@CategoryActivity, TechNewsActivity::class.java)
            startActivity(intent)
        })

        cardCatTesla.setOnClickListener({
            val intent = Intent(this@CategoryActivity, TeslaNewsActivity::class.java)
            startActivity(intent)
        })

        cardCatWs.setOnClickListener({
            val intent = Intent(this@CategoryActivity, WallStreetActivity::class.java)
            startActivity(intent)
        })
    }
}