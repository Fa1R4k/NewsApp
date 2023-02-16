package com.example.newsapp.data

import com.example.newsapp.data.mappers.NewsDataMapper
import com.example.newsapp.domain.NewsData
import com.example.newsapp.domain.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsService: NewsService,
    private val mapper: NewsDataMapper,
) : NewsRepository {

    override suspend fun getListNewsData(): List<NewsData> {
        return withContext(Dispatchers.IO) {
            val articles = newsService.getNews("techcrunch.com,thenextweb.com").execute().body()
                ?: throw Exception()
            return@withContext articles.articles?.map { mapper(it) } ?: listOf()
        }
    }
}