package com.adl.newsappmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.R

import com.adl.newsappmandiri.model.ArticlesItemWallStreet

class WallStreetNewsAdapter(val wsData: ArrayList<ArticlesItemWallStreet>): RecyclerView.Adapter<WallStreetNewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WallStreetNewsVH {
        this.parent = parent
        return WallStreetNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_wallstreet,parent,false))
    }

    override fun getItemCount(): Int {
        return wsData.size
    }

    override fun onBindViewHolder(holder: WallStreetNewsVH, position: Int) {
        holder.bindWsData(this@WallStreetNewsAdapter, position)
    }
}