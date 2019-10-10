package com.simmorsal.newsly.ui.fragments.feed

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.simmorsal.newsly.data.repository.RepositoryNews
import javax.inject.Inject

class ViewModelFeed @Inject constructor(
    private val repositoryNews: RepositoryNews
) : ViewModel() {

    val txtText = MutableLiveData<String>().apply { value = "asdfasdf" }
}