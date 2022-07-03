package com.adl.newsappmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsappmandiri.adapter.TeslaNewsAdapter
import com.adl.newsappmandiri.model.ArticlesItemTesla
import com.adl.newsappmandiri.model.ResponseTeslaNews
import com.adl.newsappmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tesla_news.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeslaNewsActivity : AppCompatActivity() {

    private lateinit var teslaNewsAdapter: TeslaNewsAdapter
    var listTeslaData = ArrayList<ArticlesItemTesla>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tesla_news)
        loadTeslaData()

        btnBackTesla.setOnClickListener({
            val intent = Intent(this@TeslaNewsActivity, CategoryActivity::class.java)
            startActivity(intent)
        })
    }

    fun loadTeslaData(){
        RetrofitConfig().getService().getTeslaData().enqueue(object  : Callback<ResponseTeslaNews>{
            override fun onResponse(
                call: Call<ResponseTeslaNews>,
                response: Response<ResponseTeslaNews>
            ) {
                Log.d("totalResult", "${response.body()?.totalResults}")
                listTeslaData = response.body()?.articles as ArrayList<ArticlesItemTesla> /* = java.util.ArrayList<com.adl.newsappmandiri.model.ArticlesItem> */
                Log.d("response", "${listTeslaData.size}")
                teslaNewsAdapter = ArrayList(listTeslaData)?.let { TeslaNewsAdapter(it) }
                rcTeslaNews.apply {
                    layoutManager = LinearLayoutManager(this@TeslaNewsActivity)
                    adapter = teslaNewsAdapter
                }
            }

            override fun onFailure(call: Call<ResponseTeslaNews>, t: Throwable) {
                Toast.makeText(this@TeslaNewsActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}