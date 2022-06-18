package com.tashuseyin.case_3gram.domain.repository

import com.tashuseyin.case_3gram.data.remote.dto.albums.AlbumsDto
import com.tashuseyin.case_3gram.data.remote.dto.comments.CommentsDto
import com.tashuseyin.case_3gram.data.remote.dto.photos.PhotosDto

interface Case3GramRepository {
    suspend fun getAlbums(): AlbumsDto
    suspend fun getPhotos(): PhotosDto
    suspend fun getComments(): CommentsDto
}