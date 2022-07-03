package com.adl.newsappmandiri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsappmandiri.adapter.AppleNewsAdapter
import com.adl.newsappmandiri.model.ArticlesItemApple
import com.adl.newsappmandiri.model.ResponseApplesNews
import com.adl.newsappmandiri.services.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var appleNewsAdapter: AppleNewsAdapter
    var listAppleData = ArrayList<ArticlesItemApple>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadAppleData()

        btnBackMain.setOnClickListener({
            val intent = Intent(this@MainActivity, CategoryActivity::class.java)
            startActivity(intent)
        })
    }

    fun loadAppleData(){
        RetrofitConfig().getService().getAppleData().enqueue(object : Callback<ResponseApplesNews>{
            override fun onResponse(
                call: Call<ResponseApplesNews>,
                response: Response<ResponseApplesNews>
            ) {
                Log.d("totalResult", "${response.body()?.totalResults}")
                listAppleData = response.body()?.articles as ArrayList<ArticlesItemApple> /* = java.util.ArrayList<com.adl.newsappmandiri.model.ArticlesItem> */
                Log.d("response", "${listAppleData.size}")
                appleNewsAdapter = ArrayList(listAppleData)?.let { AppleNewsAdapter(it) }
                rcAppleNews.apply {
                    layoutManager = LinearLayoutManager(this@MainActivity)
                    adapter = appleNewsAdapter
                }
            }

            override fun onFailure(call: Call<ResponseApplesNews>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }

        })
    }
}