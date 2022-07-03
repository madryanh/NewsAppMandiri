package com.adl.newsappmandiri.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.WebViewApple
import com.adl.newsappmandiri.WebViewBusiness
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_business.view.*
import kotlinx.android.synthetic.main.news_item.view.*

class AppleNewsVH(view: View): RecyclerView.ViewHolder(view) {
    val namaArtikel = view.txtTitleApple
    val deskripsiArtikel = view.txtDescApple
    val gambarArtikel = view.imgApple
    val cardApple = view.cardApple

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
        cardApple.setOnClickListener({
            val intent = Intent(adapter.parent.context, WebViewApple::class.java)
            intent.putExtra("dataApple", adapter.appleData.get(position))
            adapter.parent.context.startActivity(intent)
        })
    }
}