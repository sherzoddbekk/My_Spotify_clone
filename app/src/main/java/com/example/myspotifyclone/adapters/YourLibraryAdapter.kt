package com.example.myspotifyclone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myspotifyclone.databinding.ItemYourLibraryBinding
import com.example.myspotifyclone.models.YourLibrary

class YourLibraryAdapter :
    ListAdapter<YourLibrary, YourLibraryAdapter.YourLibraryViewHolder>(ITEM_DEF) {

    companion object {
        val ITEM_DEF = object : DiffUtil.ItemCallback<YourLibrary>() {
            override fun areItemsTheSame(oldItem: YourLibrary, newItem: YourLibrary): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: YourLibrary, newItem: YourLibrary): Boolean {
                return oldItem == newItem
            }
        }
    }

    inner class YourLibraryViewHolder(private val binding: ItemYourLibraryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            val item = getItem(position)

            with(binding){
                Glide.with(root).load(item).into(ivPicture)
                tvTitle.text = item.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YourLibraryViewHolder {
        return YourLibraryViewHolder(
            ItemYourLibraryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: YourLibraryViewHolder, position: Int) {
        holder.bind()
    }

}