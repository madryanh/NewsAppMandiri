package com.adl.newsappmandiri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsappmandiri.adapter.BusinessNewsAdapter
import com.adl.newsappmandiri.adapter.TechNewsAdapter
import com.adl.newsappmandiri.adapter.WallStreetNewsAdapter
import com.adl.newsappmandiri.model.*
import com.adl.newsappmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_tech_news.*
import kotlinx.android.synthetic.main.activity_wall_street.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WallStreetActivity : AppCompatActivity() {

    private lateinit var wallStreetNewsAdapter: WallStreetNewsAdapter
    var listWsData = ArrayList<ArticlesItemWallStreet>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wall_street)
        loadWsData()
    }

    fun loadWsData(){
        RetrofitConfig().getService().getWsData().enqueue(object : Callback<ResponseWallStreetNews> {
            override fun onResponse(
                call: Call<ResponseWallStreetNews>,
                response: Response<ResponseWallStreetNews>
            ) {
                Log.d("totalResult", "${response.body()?.totalResults}")
                listWsData = response.body()?.articles as ArrayList<ArticlesItemWallStreet> /* = java.util.ArrayList<com.adl.newsappmandiri.model.ArticlesItem> */
                Log.d("response", "${listWsData.size}")
                wallStreetNewsAdapter = ArrayList(listWsData)?.let { WallStreetNewsAdapter(it) }
                rcWsNews.apply {
                    layoutManager = LinearLayoutManager(this@WallStreetActivity)
                    adapter = wallStreetNewsAdapter
                }
            }

            override fun onFailure(call: Call<ResponseWallStreetNews>, t: Throwable) {
                Toast.makeText(this@WallStreetActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }

}