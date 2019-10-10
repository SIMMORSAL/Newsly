package com.simmorsal.newsly.di.modules

import androidx.lifecycle.ViewModel
import com.simmorsal.newsly.di.ViewModelKey
import com.simmorsal.newsly.ui.activities.ViewModelMainActivity
import com.simmorsal.newsly.ui.fragments.feed.ViewModelFeed
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ModuleViewModel {

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelMainActivity::class)
    abstract fun bindViewModel(newsViewModel: ViewModelMainActivity): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ViewModelFeed::class)
    abstract fun bindViewModelFeed(viewModelFeed: ViewModelFeed): ViewModel
}

//@Module
//abstract class ModuleViewModelFeed {
//}