package com.adl.newsappmandiri.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.WebViewNewsActivity
import com.adl.newsappmandiri.WebViewTesla
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_item.view.*
import kotlinx.android.synthetic.main.news_tesla.view.*

class TeslaNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikelTesla = view.txtTitleTesla
    val deskripsiArtikelTesla = view.txtDescTesla
    val gambarArtikelTesla = view.imgTesla
    val cardTesla = view.cardTesla

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
        cardTesla.setOnClickListener({
            val intent = Intent(adapter.parent.context, WebViewTesla::class.java)
            intent.putExtra("dataTesla", adapter.teslaData.get(position))
            adapter.parent.context.startActivity(intent)
        })
    }
}