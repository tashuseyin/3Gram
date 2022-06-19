package com.tashuseyin.case_3gram.presentation.albums.adapter

import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayoutMediator
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class HomeViewHolder(private val binding: AlbumItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val sliderAdapter = SliderImageAdapter()

    fun bind(albumItem: Pair<AlbumItem, List<PhotoItem>>) {
        binding.apply {
            albumTitle.text = albumItem.first.title
            sliderAdapter.setData(albumItem.second)
            binding.viewPager.adapter = sliderAdapter
            TabLayoutMediator(binding.tabLayout, binding.viewPager) { _, _ -> }.attach()
        }
    }
}