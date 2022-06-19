package com.tashuseyin.case_3gram.presentation.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    var albumList = emptyList<AlbumItem>()
    var photoItemList = emptyList<PhotoItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            AlbumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(albumList[position])
        setPhotoItemRecycler(holder.itemRecycler!!)
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    private fun setPhotoItemRecycler(recyclerView: RecyclerView) {
        val itemRecyclerAdapter = PhotoAdapter(photoItemList)
        recyclerView.adapter = itemRecyclerAdapter
    }

    fun setData(newAlbumList: List<AlbumItem>, newPhotoList: List<PhotoItem>) {
        this.albumList = newAlbumList
        this.photoItemList = newPhotoList
    }
}