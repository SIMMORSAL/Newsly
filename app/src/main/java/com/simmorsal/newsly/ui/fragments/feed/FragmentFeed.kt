package com.simmorsal.newsly.ui.fragments.feed


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.simmorsal.newsly.R
import com.simmorsal.newsly.databinding.FragmentFeedBinding
import javax.inject.Inject

class FragmentFeed : Fragment() {

    lateinit var binding: FragmentFeedBinding
    lateinit var viewModel: ViewModelFeed
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_feed, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewModelFeed::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this



        return binding.root
    }


}
