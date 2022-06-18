package com.tashuseyin.case_3gram.data.remote.dto.comments

data class CommentsDtoItem(
    val body: String? = "",
    val email: String? = "",
    val id: Int? = 0,
    val name: String? = "",
    val postId: Int? = 0
)