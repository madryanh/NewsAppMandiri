package com.adl.newsappmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsappmandiri.adapter.AppleNewsAdapter
import com.adl.newsappmandiri.adapter.TechNewsAdapter
import com.adl.newsappmandiri.model.ArticlesItemApple
import com.adl.newsappmandiri.model.ArticlesItemTech
import com.adl.newsappmandiri.model.ResponseApplesNews
import com.adl.newsappmandiri.model.ResponseTechNews
import com.adl.newsappmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tech_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TechNewsActivity : AppCompatActivity() {

    private lateinit var techNewsAdapter: TechNewsAdapter
    var listTechData = ArrayList<ArticlesItemTech>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tech_news)
        loadTechData()

        btnBackTech.setOnClickListener({
            val intent = Intent(this@TechNewsActivity, CategoryActivity::class.java)
            startActivity(intent)
        })
    }
    fun loadTechData(){
        RetrofitConfig().getService().getTechData().enqueue(object : Callback<ResponseTechNews> {

            override fun onResponse(
                call: Call<ResponseTechNews>,
                response: Response<ResponseTechNews>
            ) {
                Log.d("totalResult", "${response.body()?.totalResults}")
                listTechData = response.body()?.articles as ArrayList<ArticlesItemTech> /* = java.util.ArrayList<com.adl.newsappmandiri.model.ArticlesItem> */
                Log.d("response", "${listTechData.size}")
                techNewsAdapter = ArrayList(listTechData)?.let { TechNewsAdapter(it) }
                rcTechNews.apply {
                    layoutManager = LinearLayoutManager(this@TechNewsActivity)
                    adapter = techNewsAdapter
                }
            }

            override fun onFailure(call: Call<ResponseTechNews>, t: Throwable) {
                Toast.makeText(this@TechNewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}