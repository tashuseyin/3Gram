package com.tashuseyin.case_3gram.presentation.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem

//class AlbumsAdapter : RecyclerView.Adapter<AlbumsViewHolder>() {
//    var albumList = emptyList<AlbumItem>()
//    var photoList = emptyList<PhotoItem>()
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
//        val binding =
//            AlbumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return AlbumsViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
//        holder.bind(albumList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return albumList.size
//    }
//
//    fun setData(newAlbumList: List<Albums>) {
//        this.albumList = newAlbumList
//    }
//}