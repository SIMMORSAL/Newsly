package com.simmorsal.newsly.data.remote

import com.simmorsal.newsly.data.model.ModelTopHeadlines
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("top-headlines")
    fun topHeadlines(
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String,
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("q") q: String
    ): Single<ModelTopHeadlines>
}