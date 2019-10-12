package com.simmorsal.newsly.ui.fragments.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.simmorsal.newsly.data.model.ArticlesItem
import com.simmorsal.newsly.databinding.RvNewsFeedBinding

class AdapterFeed(private val clickListener: ClickListenerFeed) :
    ListAdapter<ArticlesItem, RecyclerView.ViewHolder>(DiffCallbackFeed()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)
        (holder as ViewHolder).bind(position, item, clickListener)
    }

    class ViewHolder private constructor(val binding: RvNewsFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(
            position: Int,
            item: ArticlesItem,
            clickListener: ClickListenerFeed
        ) {
            binding.position = position
            binding.item = item
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RvNewsFeedBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }
}

class ClickListenerFeed(val clickListener: (position: Int) -> Unit) {
    fun onClick(position: Int) = clickListener(position)
}

class DiffCallbackFeed : DiffUtil.ItemCallback<ArticlesItem>() {
    override fun areContentsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: ArticlesItem, newItem: ArticlesItem): Boolean {
        return oldItem.url == newItem.url
    }
}