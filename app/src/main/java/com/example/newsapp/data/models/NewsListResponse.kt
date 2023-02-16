package com.example.newsapp.data.models

import com.google.gson.annotations.SerializedName

data class NewsListResponse(
    @SerializedName("articles") val articles: List<NewsResponse>? = null,
)