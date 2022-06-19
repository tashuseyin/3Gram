package com.tashuseyin.case_3gram.presentation.albums.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.databinding.AlbumItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem

class HomeAdapter : RecyclerView.Adapter<HomeViewHolder>() {
    private var albumList = emptyList<Pair<AlbumItem, List<PhotoItem>>>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding =
            AlbumItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.bind(albumList[position])
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

    fun setData(newAlbumList: List<Pair<AlbumItem, List<PhotoItem>>>) {
        this.albumList = newAlbumList
    }
}