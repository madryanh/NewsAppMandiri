package com.adl.newsappmandiri.services


import com.adl.newsappmandiri.model.ResponseApplesNews
import com.adl.newsappmandiri.model.ResponseBusinessNews
import com.adl.newsappmandiri.model.ResponseTechNews
import com.adl.newsappmandiri.model.ResponseTeslaNews
import retrofit2.http.GET

interface IAppleData {

    @GET("v2/everything?q=apple&from=2022-07-02&to=2022-07-02&sortBy=popularity&apiKey=61a586c66d044316a6648da79b2607db")
    fun getAppleData(): retrofit2.Call<ResponseApplesNews>

    @GET("v2/everything?q=tesla&from=2022-06-03&sortBy=publishedAt&apiKey=61a586c66d044316a6648da79b2607db")
    fun getTeslaData(): retrofit2.Call<ResponseTeslaNews>

    @GET("v2/top-headlines?country=us&category=business&apiKey=61a586c66d044316a6648da79b2607db")
    fun getBusinessData(): retrofit2.Call<ResponseBusinessNews>

    @GET("v2/top-headlines?sources=techcrunch&apiKey=61a586c66d044316a6648da79b2607db")
    fun getTechData(): retrofit2.Call<ResponseTechNews>
}