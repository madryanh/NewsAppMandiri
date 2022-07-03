package com.adl.newsappmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsappmandiri.adapter.BusinessNewsAdapter
import com.adl.newsappmandiri.adapter.TeslaNewsAdapter
import com.adl.newsappmandiri.model.*
import com.adl.newsappmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_tesla_news.*
import kotlinx.android.synthetic.main.activity_top_business.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TopBusinessActivity : AppCompatActivity() {

    private lateinit var businessNewsAdapter: BusinessNewsAdapter
    var listBusinessData = ArrayList<ArticlesItemBusines>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_business)
        loadBusinessData()

        btnBackBusiness.setOnClickListener({
            val intent = Intent(this@TopBusinessActivity, CategoryActivity::class.java)
            startActivity(intent)
        })
    }

    fun loadBusinessData(){
        RetrofitConfig().getService().getBusinessData().enqueue(object  : Callback<ResponseBusinessNews> {
            override fun onResponse(
                call: Call<ResponseBusinessNews>,
                response: Response<ResponseBusinessNews>
            ) {
                Log.d("totalResult", "${response.body()?.totalResults}")
                listBusinessData = response.body()?.articles as ArrayList<ArticlesItemBusines> /* = java.util.ArrayList<com.adl.newsappmandiri.model.ArticlesItem> */
                Log.d("response", "${listBusinessData.size}")
                businessNewsAdapter = ArrayList(listBusinessData)?.let { BusinessNewsAdapter(it) }
                rcBusinessNews.apply {
                    layoutManager = LinearLayoutManager(this@TopBusinessActivity)
                    adapter = businessNewsAdapter
                }
            }

            override fun onFailure(call: Call<ResponseBusinessNews>, t: Throwable) {
                Toast.makeText(this@TopBusinessActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}