package com.simmorsal.newsly.ui.activities

import android.util.Log
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


class ViewModelMainActivity @Inject constructor(
    private val repositoryNews: RepositoryNews
) : ViewModel() {

    private val disposable = CompositeDisposable()

    private val _newsData = MutableLiveData<ModelTopHeadlines>()
    val newsData: LiveData<ModelTopHeadlines>
        get() {
//            loadNews()
            return _newsData
        }

    var totalResults = MutableLiveData<String>()
        .apply { value = "No Data Yet" }

    init {
        loadNews()
    }

    private fun loadNews() {

        disposable.add(
            repositoryNews.modelTopHeadlines(1, NEWSAPI_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ModelTopHeadlines>() {
                    override fun onSuccess(t: ModelTopHeadlines) {
                        _newsData.value = t
                        totalResults.value = t.totalResults.toString()

                        Log.i("11111", "ViewModelMainActivity => onSuccess:  " + totalResults)
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}