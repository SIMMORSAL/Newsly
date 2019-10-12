package com.simmorsal.newsly.di.modules

import com.simmorsal.newsly.di.SharedPreffInfo
import com.simmorsal.newsly.utils.SHARED_PREFF_NAME
import dagger.Module
import dagger.Provides

@Module
class ModuleApp {

    @Provides
    @SharedPreffInfo
    fun provideSharedPreffFileName() = SHARED_PREFF_NAME
}