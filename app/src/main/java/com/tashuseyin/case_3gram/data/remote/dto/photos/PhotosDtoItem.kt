package com.tashuseyin.case_3gram.data.remote.dto.photos

data class PhotosDtoItem(
    val albumId: Int? = 0,
    val id: Int? = 0,
    val thumbnailUrl: String? = "",
    val title: String? = "",
    val url: String? = ""
)