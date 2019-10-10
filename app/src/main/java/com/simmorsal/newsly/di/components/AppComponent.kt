package com.simmorsal.newsly.di.components

import com.simmorsal.newsly.di.modules.ModuleContext
import com.simmorsal.newsly.di.modules.ModuleNetwork
import com.simmorsal.newsly.ui.activities.ActivityMain
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ModuleNetwork::class, ModuleContext::class])
interface AppComponent {
    fun inject(mainActivity: ActivityMain)
}