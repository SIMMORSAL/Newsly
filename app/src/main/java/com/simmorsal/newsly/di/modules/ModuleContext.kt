package com.simmorsal.newsly.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleContext(
    context: Context
) {
    @Binds
    abstract fun bindContext(application: Application): Context

}