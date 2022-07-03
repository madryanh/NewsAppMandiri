package com.adl.newsappmandiri.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.news_tesla.view.*

class TeslaNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikelTesla = view.txtTitleTesla
    val deskripsiArtikelTesla = view.txtDescTesla
    val gambarArtikelTesla = view.imgTesla

    fun bindTeslaData(adapter: TeslaNewsAdapter, position:Int){
        namaArtikelTesla.setText(adapter.teslaData.get(position).title.toString())
        deskripsiArtikelTesla.setText(adapter.teslaData.get(position).description.toString())
        gambarArtikelTesla.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter?.teslaData.get(position).urlToImage)
                .into(it)
        }
    }
}