package com.tashuseyin.case_3gram.presentation.comments

import com.tashuseyin.case_3gram.domain.model.CommentItem

data class CommentsState(
    val isLoading: Boolean = false,
    val commentsList: List<CommentItem> = emptyList(),
    val errorText: String = ""
)
