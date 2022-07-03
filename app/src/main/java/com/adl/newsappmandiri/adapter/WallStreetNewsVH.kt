package com.adl.newsappmandiri.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_wallstreet.view.*

class WallStreetNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikel = view.txtTitleWs
    val deskripsiArtikel = view.txtDescWs
    val gambarArtikel = view.imgWs

    fun bindWsData(adapter: WallStreetNewsAdapter, position:Int){
        namaArtikel.setText(adapter.wsData.get(position).title.toString())
        deskripsiArtikel.setText(adapter.wsData.get(position).description.toString())
        gambarArtikel.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter?.wsData.get(position).urlToImage)
                .into(it)
        }
    }
}