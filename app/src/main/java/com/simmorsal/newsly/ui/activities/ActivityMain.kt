package com.simmorsal.newsly.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.simmorsal.newsly.R
import com.simmorsal.newsly.base.Application
import com.simmorsal.newsly.databinding.ActivityMainBinding
import javax.inject.Inject

class ActivityMain : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ViewModelMainActivity
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        (application as Application).appComponent.inject(this)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ViewModelMainActivity::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }
}
