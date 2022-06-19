package com.tashuseyin.case_3gram.presentation.albums.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.R
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem

class HomeViewHolder(private val binding: AlbumItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
    var itemRecycler: RecyclerView? = null
    init {
        itemRecycler = itemView.findViewById(R.id.view_pager)
    }
    fun bind(albumItem: AlbumItem) {
        binding.apply {
            albumTitle.text = albumItem.title
        }
    }
}