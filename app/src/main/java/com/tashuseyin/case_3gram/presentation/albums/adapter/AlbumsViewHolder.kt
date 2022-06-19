package com.tashuseyin.case_3gram.presentation.albums.adapter

import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.models.SlideModel
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class AlbumsViewHolder(private val binding: AlbumItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(albumItem: AlbumItem, photoItem: PhotoItem) {
        binding.apply {
            albumTitle.text = albumItem.title
            albumDetail.text = photoItem.title
            sliderImage.setImageList(listOf(SlideModel(photoItem.url!!.filter {
                photoItem.albumId == albumItem.id
            })))
        }
    }
}