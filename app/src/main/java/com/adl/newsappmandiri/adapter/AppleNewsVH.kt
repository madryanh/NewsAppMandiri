package com.adl.newsappmandiri.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_item.view.*

class AppleNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikel = view.txtTitleApple
    val deskripsiArtikel = view.txtDescApple
    val gambarArtikel = view.imgApple

    fun bindAppleData(adapter: AppleNewsAdapter, position:Int){
        namaArtikel.setText(adapter.appleData.get(position).title.toString())
        deskripsiArtikel.setText(adapter.appleData.get(position).description.toString())
        gambarArtikel.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter?.appleData.get(position).urlToImage)
                .into(it)
        }
    }
}