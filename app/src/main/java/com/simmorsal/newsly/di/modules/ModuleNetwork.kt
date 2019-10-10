package com.simmorsal.newsly.di.modules

import com.simmorsal.newsly.data.remote.NewsService
import com.simmorsal.newsly.utils.BASE_URL
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ModuleViewModel::class, ModuleViewModelFactory::class])
object ModuleNetwork {

    @JvmStatic
    @Provides
    @Singleton
    fun provideRetrofit() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()


    @JvmStatic
    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit) = retrofit.create(NewsService::class.java)

}