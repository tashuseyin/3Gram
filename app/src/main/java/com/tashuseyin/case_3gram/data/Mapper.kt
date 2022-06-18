package com.tashuseyin.case_3gram.data

import com.tashuseyin.case_3gram.data.remote.dto.albums.AlbumDtoItem
import com.tashuseyin.case_3gram.data.remote.dto.comments.CommentsDtoItem
import com.tashuseyin.case_3gram.data.remote.dto.photos.PhotosDtoItem
import com.tashuseyin.case_3gram.domain.model.AlbumItem
import com.tashuseyin.case_3gram.domain.model.CommentItem
import com.tashuseyin.case_3gram.domain.model.PhotoItem


fun AlbumDtoItem.toDomain(): AlbumItem {
    return AlbumItem(
        id = id,
        title = title
    )
}

fun PhotosDtoItem.toDomain(): PhotoItem {
    return PhotoItem(
        albumId = albumId,
        thumbnailUrl = thumbnailUrl,
        title = title,
        url = url
    )
}

fun CommentsDtoItem.toDomain(): CommentItem {
    return CommentItem(
        email = email,
        name = name,
        body = body
    )
}