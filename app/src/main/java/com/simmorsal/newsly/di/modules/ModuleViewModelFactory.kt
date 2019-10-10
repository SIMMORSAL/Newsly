package com.simmorsal.newsly.di.modules

import androidx.lifecycle.ViewModelProvider
import com.simmorsal.newsly.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ModuleViewModelFactory {

    @Binds
    abstract fun bindFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}