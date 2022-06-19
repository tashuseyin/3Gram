package com.tashuseyin.case_3gram.presentation.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.common.extension.loadImageView
import com.tashuseyin.case_3gram.databinding.SliderImageContainerBinding
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class SliderImageAdapter : RecyclerView.Adapter<SliderImageAdapter.SliderImageViewHolder>() {
    private var imageList = emptyList<PhotoItem>()

    inner class SliderImageViewHolder(private val binding: SliderImageContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoItem: PhotoItem, size: Int) {
            binding.albumImage.loadImageView(
                photoItem.url
            )
            binding.imageTitle.text = photoItem.title

            if (adapterPosition == size - 1) {
                binding.slideNextButton.isVisible = false
            }

            if (adapterPosition > 0) {
                binding.slideBeforeButton.isVisible = true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderImageViewHolder {
        val binding =
            SliderImageContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderImageViewHolder, position: Int) {
        holder.bind(imageList[position], imageList.size)
    }

    override fun getItemCount() = imageList.size

    fun setData(newData: List<PhotoItem>) {
        this.imageList = newData
    }
}