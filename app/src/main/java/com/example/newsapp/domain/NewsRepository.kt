package com.example.newsapp.domain

interface NewsRepository {

    suspend fun getListNewsData(): List<NewsData>
}