package com.adl.newsappmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.R
import com.adl.newsappmandiri.model.ArticlesItemTech

class TechNewsAdapter(val techData: ArrayList<ArticlesItemTech>): RecyclerView.Adapter<TechNewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TechNewsVH {
        this.parent = parent
        return TechNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))
    }

    override fun getItemCount(): Int {
        return techData.size
    }

    override fun onBindViewHolder(holder: TechNewsVH, position: Int) {
        holder.bindTechData(this@TechNewsAdapter, position)
    }
}