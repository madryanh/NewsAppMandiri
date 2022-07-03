package com.adl.newsappmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.R
import com.adl.newsappmandiri.model.ArticlesItemBusines


class BusinessNewsAdapter(val businessData: ArrayList<ArticlesItemBusines>): RecyclerView.Adapter<BusinessNewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BusinessNewsVH {
        this.parent = parent
        return BusinessNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_business,parent,false))
    }

    override fun getItemCount(): Int {
        return businessData.size
    }

    override fun onBindViewHolder(holder: BusinessNewsVH, position: Int) {
        holder.bindBusinessData(this@BusinessNewsAdapter, position)
    }
}