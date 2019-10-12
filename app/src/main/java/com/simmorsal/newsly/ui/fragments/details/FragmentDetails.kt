package com.simmorsal.newsly.ui.fragments.details


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.simmorsal.newsly.R
import com.simmorsal.newsly.base.Application
import com.simmorsal.newsly.databinding.FragmentDetailsBinding
import javax.inject.Inject

class FragmentDetails : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ViewModelDetails
    lateinit var binding: FragmentDetailsBinding
    lateinit var argument: FragmentDetailsArgs

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_details, container, false)
        (requireNotNull(activity).application as Application).appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ViewModelDetails::class.java)
        binding.lifecycleOwner = this
        argument = FragmentDetailsArgs.fromBundle(arguments!!)

        setupData()

        return binding.root
    }

    private fun setupData() {
        binding.item = argument.item
    }


}
