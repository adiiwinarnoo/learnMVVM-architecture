package com.example.belajarmvvm.data.model

import com.google.gson.annotations.SerializedName

data class TopHeadlinesResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticlesItem> = ArrayList(),

	@field:SerializedName("status")
	val status: String? = null,
)

data class Source(
	@SerializedName("id")
	val id: String? = null,
	@SerializedName("name")
	val name: String = "",
)

data class ArticlesItem(

	@field:SerializedName("urlToImage")
	val urlToImage: String? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("url")
	val url: String? = null,
	@field:SerializedName("source")
	val source: Source
)
