package com.simmorsal.newsly.ui.fragments.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simmorsal.newsly.data.Repository
import com.simmorsal.newsly.data.model.ArticlesItem
import com.simmorsal.newsly.data.model.ModelTopHeadlines
import com.simmorsal.newsly.utils.NEWSAPI_KEY
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ViewModelFeed @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private var page = 0
    private val disposable = CompositeDisposable()

//    private val _dataTopHeadlines = MutableLiveData<ModelTopHeadlines>()
//    val dataTopHeadlines: LiveData<ModelTopHeadlines>
//        get() = _dataTopHeadlines

    private val _dataArticles = MutableLiveData<MutableList<ArticlesItem>>()
        .apply { value = mutableListOf() }
    val dataArticles: LiveData<MutableList<ArticlesItem>>
        get() = _dataArticles

    private val _toastText = MutableLiveData<String>()
    val toastText: LiveData<String>
        get() = _toastText

    private val _navigateToDetails = MutableLiveData<ArticlesItem>()
    val navigateToDetails: LiveData<ArticlesItem>
        get() = _navigateToDetails


    init {
        page = 0
        getData()
    }

    private fun getData() {
        disposable.add(
            repository
                .modelTopHeadlines(page, NEWSAPI_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ModelTopHeadlines>() {
                    override fun onSuccess(t: ModelTopHeadlines) {
//                        _dataTopHeadlines.value = t
                        if (t.status == "ok" && t.articles != null) {
                            val list = mutableListOf<ArticlesItem>()
                            list.addAll(_dataArticles.value!!)
                            list.addAll(ArrayList<ArticlesItem>(t.articles))
                            _dataArticles.value = list
                        } else {
                            // TODO
                        }
                    }

                    override fun onError(e: Throwable) {
                        // TODO
                    }
                })
        )
    }

    fun onListEndReached() {
        page++
        getData()
    }

    fun onRefreshData() {
        _dataArticles.value?.clear()
        page = 0
        getData()
    }

    fun onItemClicked(position: Int) {
//        showToast(_dataArticles.value?.get(position)?.title!!)
        _navigateToDetails.value = _dataArticles.value?.get(position)
    }

    private fun showToast(text: String) {
        _toastText.value = text
    }

    fun doneShowingToast() {
        _toastText.value = ""
    }

    fun doneNavigatingToDetails() {
        _navigateToDetails.value = null
    }
}