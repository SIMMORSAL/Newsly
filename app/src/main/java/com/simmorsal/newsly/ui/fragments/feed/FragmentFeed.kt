package com.simmorsal.newsly.ui.fragments.feed


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.simmorsal.newsly.R
import com.simmorsal.newsly.base.Application
import com.simmorsal.newsly.databinding.FragmentFeedBinding
import com.simmorsal.newsly.utils.isPhonePortrait
import javax.inject.Inject

class FragmentFeed : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: ViewModelFeed

    private lateinit var adapter: AdapterFeed

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity!!.application as Application).appComponent.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_feed, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewModelFeed::class.java)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setupRv()
        setupViewModelObservers()

        return binding.root
    }

    private fun setupRv() {
        adapter = AdapterFeed(ClickListenerFeed { itemPosition ->
            viewModel.onItemClicked(itemPosition)
        })
        val gridCount = if (isPhonePortrait(activity as Context)) 1 else 2
        val layoutManager = GridLayoutManager(activity, gridCount)
        binding.rvFeed.adapter = adapter
        binding.rvFeed.layoutManager = layoutManager
    }

    private fun setupViewModelObservers() {
        viewModel.toastText.observe(this, Observer {
            if (it.isNotEmpty()) {
                Toast.makeText(activity, it, Toast.LENGTH_SHORT).show()
                viewModel.doneShowingToast()
            }
        })

        viewModel.dataArticles.observe(this, Observer {
            adapter.submitList(it)
        })
    }
}
