package com.adl.newsappmandiri.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseBusinessNews(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItemBusines?>? = null,

	@field:SerializedName("status")
	val status: String? = null
) : Parcelable

@Parcelize
data class ArticlesItemBusines(

	@field:SerializedName("publishedAt")
	val publishedAt: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("urlToImage")
	val urlToImageBusiness: String? = null,

	@field:SerializedName("description")
	val descriptionBusiness: String? = null,

	@field:SerializedName("source")
	val source: Source? = null,

	@field:SerializedName("title")
	val titleBusiness: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("content")
	val content: String? = null
) : Parcelable

@Parcelize
data class SourceBusines(

	@field:SerializedName("name")
	val name: String? = null,

//	@field:SerializedName("id")
//	val id: Any? = null
) : Parcelable
