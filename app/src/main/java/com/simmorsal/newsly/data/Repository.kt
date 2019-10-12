package com.simmorsal.newsly.data

import com.simmorsal.newsly.data.model.ModelTopHeadlines
import com.simmorsal.newsly.data.remote.NewsService
import io.reactivex.Single
import javax.inject.Inject

class Repository @Inject constructor(
    private var newsService: NewsService
) {

    fun modelTopHeadlines(
        page: Int,
        apiKey: String,
        country: String = "us", // ae ar at au be bg br ca ch cn co cu cz de eg fr gb gr hk hu id ie il in it jp kr lt lv ma mx my ng nl no nz ph pl pt ro rs ru sa se sg si sk th tr tw ua us ve za
        category: String = "technology", // business entertainment general health science sports technology
        q: String = ""
    ): Single<ModelTopHeadlines> = newsService.topHeadlines(page, apiKey, country, category, q)
}