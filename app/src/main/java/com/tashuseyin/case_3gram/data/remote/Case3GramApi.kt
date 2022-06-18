package com.tashuseyin.case_3gram.data.remote

import com.tashuseyin.case_3gram.common.Constant
import com.tashuseyin.case_3gram.data.remote.dto.albums.AlbumsDto
import com.tashuseyin.case_3gram.data.remote.dto.comments.CommentsDto
import com.tashuseyin.case_3gram.data.remote.dto.photos.PhotosDto
import retrofit2.http.GET

interface Case3GramApi {

    @GET(Constant.albums)
    suspend fun getAlbums(): AlbumsDto

    @GET(Constant.photos)
    suspend fun getPhotos(): PhotosDto

    @GET(Constant.comments)
    suspend fun getComments(): CommentsDto
}