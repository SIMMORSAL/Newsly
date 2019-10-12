package com.simmorsal.newsly.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromNet")
fun ImageView.imageFromNet(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .into(this)
    }
}

@BindingAdapter("imageFromNetCenterCrop")
fun ImageView.imageFromNetCenterCrop(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(this)
    }
}

@BindingAdapter("openLink")
fun View.openLink(url: String?) {
    url?.let {
        setOnClickListener {
            openLink(this.context, url)
        }
    }
}