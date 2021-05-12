package com.lleans.restapi.retrofit

data class RetrofitResponse(
    val totalResults: Int,
    val articles: List<ArticlesItem>,
    val status: String
)

data class Source(
    val name: String,
    val id: Any
)

data class ArticlesItem(
    val publishedAt: String,
    val author: String,
    val urlToImage: String,
    val description: String,
    val source: Source,
    val title: String,
    val url: String,
    val content: String
)

