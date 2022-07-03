package com.adl.newsappmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.R
import com.adl.newsappmandiri.model.ArticlesItemApple
import com.adl.newsappmandiri.model.ArticlesItemTesla

class TeslaNewsAdapter(val teslaData: ArrayList<ArticlesItemTesla>): RecyclerView.Adapter<TeslaNewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeslaNewsVH {
        this.parent = parent
        return TeslaNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_tesla,parent,false))
    }

    override fun getItemCount(): Int {
        return teslaData.size
    }

    override fun onBindViewHolder(holder: TeslaNewsVH, position: Int) {
        holder.bindTeslaData(this@TeslaNewsAdapter, position)
    }
}