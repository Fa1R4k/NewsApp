package com.example.newsapp.data.mappers

import com.example.newsapp.data.models.NewsResponse
import com.example.newsapp.domain.NewsData
import javax.inject.Inject

class NewsDataMapper @Inject constructor() {

    operator fun invoke(response: NewsResponse): NewsData = with(response) {
        return NewsData(
            title = title.orEmpty(),
            imageLink = imageLink.orEmpty(),
            url = url.orEmpty(),
            author = author.orEmpty()
        )
    }
}