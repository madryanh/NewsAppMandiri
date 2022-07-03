package com.adl.newsappmandiri.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.WebViewNewsActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_wallstreet.view.*

class WallStreetNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikel = view.txtTitleWs
    val deskripsiArtikel = view.txtDescWs
    val gambarArtikel = view.imgWs
    val cardWS = view.cardWs

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
        cardWS.setOnClickListener({
            val intent = Intent(adapter.parent.context, WebViewNewsActivity::class.java)
            intent.putExtra("data", adapter.wsData.get(position))
            adapter.parent.context.startActivity(intent)
        })
    }
}