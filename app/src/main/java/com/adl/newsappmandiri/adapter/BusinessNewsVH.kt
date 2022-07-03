package com.adl.newsappmandiri.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.WebViewBusiness
import com.adl.newsappmandiri.WebViewTech
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_business.view.*
import kotlinx.android.synthetic.main.news_tech.view.*
import kotlinx.android.synthetic.main.news_wallstreet.view.*


class BusinessNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikelBusniess = view.txtTitleBusiness
    val deskripsiArtikelBusiness = view.txtDescBusiness
    val gambarArtikelBusiness = view.imgBusiness
    val cardBusiness = view.cardBusiness

    fun bindBusinessData(adapter: BusinessNewsAdapter, position:Int){
        namaArtikelBusniess.setText(adapter.businessData.get(position).titleBusiness.toString())
        deskripsiArtikelBusiness.setText(adapter.businessData.get(position).descriptionBusiness.toString())
        gambarArtikelBusiness.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter?.businessData.get(position).urlToImageBusiness)
                .into(it)
        }
        cardBusiness.setOnClickListener({
            val intent = Intent(adapter.parent.context, WebViewBusiness::class.java)
            intent.putExtra("dataWs", adapter.businessData.get(position))
            adapter.parent.context.startActivity(intent)
        })
    }
}