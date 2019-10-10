package com.simmorsal.newsly.base

import android.app.Application
import com.simmorsal.newsly.di.components.AppComponent
import com.simmorsal.newsly.di.components.DaggerAppComponent

class Application : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.create()
    }
}