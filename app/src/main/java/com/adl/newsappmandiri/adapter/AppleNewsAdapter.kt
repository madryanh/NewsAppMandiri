package com.adl.newsappmandiri.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsappmandiri.R
import com.adl.newsappmandiri.model.ArticlesItemApple

class AppleNewsAdapter(val appleData: ArrayList<ArticlesItemApple>): RecyclerView.Adapter<AppleNewsVH>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleNewsVH {
        this.parent = parent
        return AppleNewsVH(LayoutInflater.from(parent.context).inflate(R.layout.news_item,parent,false))
    }

    override fun onBindViewHolder(holder: AppleNewsVH, position: Int) {
        holder.bindAppleData(this@AppleNewsAdapter, position)
    }

    override fun getItemCount(): Int {
        return appleData.size
    }
}