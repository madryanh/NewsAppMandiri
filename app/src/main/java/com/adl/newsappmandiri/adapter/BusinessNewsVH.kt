package com.adl.newsappmandiri.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_business.view.*


class BusinessNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikelBusniess = view.txtTitleBusiness
    val deskripsiArtikelBusiness = view.txtDescBusiness
    val gambarArtikelBusiness = view.imgBusiness

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
    }
}