package com.simmorsal.newsly.ui.fragments.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simmorsal.newsly.data.model.ModelTopHeadlines
import com.simmorsal.newsly.data.repository.RepositoryNews
import com.simmorsal.newsly.utils.NEWSAPI_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewModelFeed @Inject constructor(
    private val repositoryNews: RepositoryNews
) : ViewModel() {

    val txtText = MutableLiveData<String>().apply { value = "asdfasdf" }

    private var page = 0

    private val disposable = CompositeDisposable()
    private val _dataTopHeadlines = MutableLiveData<ModelTopHeadlines>()
    val dataTopHeadlines: LiveData<ModelTopHeadlines>
        get() = _dataTopHeadlines

    init {
        page = 0
        getData()
    }

    private fun getData() {
        disposable.add(
            repositoryNews
                .modelTopHeadlines(page, NEWSAPI_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ModelTopHeadlines>() {
                    override fun onSuccess(t: ModelTopHeadlines) {
                        _dataTopHeadlines.value = t
                        txtText.value = t.articles?.get(0)?.title
                    }

                    override fun onError(e: Throwable) {

                    }
                })
        )
    }

    fun onAllDataViewed() {
        page++
        getData()
    }
}