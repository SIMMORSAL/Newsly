package com.simmorsal.newsly.ui.activities

import androidx.lifecycle.ViewModel
import com.simmorsal.newsly.data.repository.RepositoryNews
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject


class ViewModelMainActivity @Inject constructor(
    private val repositoryNews: RepositoryNews
) : ViewModel() {

    private val disposable = CompositeDisposable()


    init {
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}