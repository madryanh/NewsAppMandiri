package com.adl.newsappmandiri.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_tech.view.*

class TechNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikel = view.txtTitleTech
    val deskripsiArtikel = view.txtDescTech
    val gambarArtikel = view.imgTech

    fun bindTechData(adapter: TechNewsAdapter, position:Int){
        namaArtikel.setText(adapter.techData.get(position).title.toString())
        deskripsiArtikel.setText(adapter.techData.get(position).description.toString())
        gambarArtikel.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter?.techData.get(position).urlToImage)
                .into(it)
        }
    }
}