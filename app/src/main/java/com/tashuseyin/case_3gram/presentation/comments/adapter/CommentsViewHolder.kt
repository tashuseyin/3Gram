package com.tashuseyin.case_3gram.presentation.comments.adapter

import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.databinding.CommentItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.CommentItem

class CommentsViewHolder(private val binding: CommentItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(commentItem: CommentItem) {
        binding.apply {
            commentsName.text = commentItem.name
            commentsBody.text = commentItem.body
        }
    }
}