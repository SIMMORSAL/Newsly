package com.simmorsal.newsly.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageFromNet")
fun ImageView.imageFromNet(url: String?) {
    url?.let {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .into(this)
    }
}