package com.tashuseyin.case_3gram.presentation.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.common.extension.loadImageView
import com.tashuseyin.case_3gram.databinding.SliderImageContainerBinding
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class SliderImageAdapter : RecyclerView.Adapter<SliderImageAdapter.SliderImageViewHolder>() {
    private var imageList = emptyList<PhotoItem>()

    inner class SliderImageViewHolder(private val binding: SliderImageContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photoItem: PhotoItem) {
            binding.albumImage.loadImageView(
                photoItem.url
            )
            binding.imageTitle.text = photoItem.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderImageViewHolder {
        val binding =
            SliderImageContainerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SliderImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderImageViewHolder, position: Int) {
        holder.bind(imageList[position])
    }

    override fun getItemCount() = imageList.size

    fun setData(newData: List<PhotoItem>) {
        this.imageList = newData
    }
}