package com.tashuseyin.case_3gram.presentation.albums.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.common.extension.loadImageView
import com.tashuseyin.case_3gram.common.extension.placeholderProgressBar
import com.tashuseyin.case_3gram.databinding.SliderImageContainerBinding
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class PhotoViewHolder(private val binding: SliderImageContainerBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(photoItem: PhotoItem) {
        binding.apply {
            albumImage.loadImageView(photoItem.url, placeholderProgressBar(albumImage.context))
            imageTitle.text = photoItem.title
        }
    }
}