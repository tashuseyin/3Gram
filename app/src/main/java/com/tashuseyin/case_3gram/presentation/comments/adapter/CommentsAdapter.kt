package com.tashuseyin.case_3gram.presentation.comments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tashuseyin.case_3gram.databinding.CommentItemLayoutBinding
import com.tashuseyin.case_3gram.domain.model.CommentItem

class CommentsAdapter : RecyclerView.Adapter<CommentsViewHolder>() {
    var commentsList = emptyList<CommentItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val binding =
            CommentItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(commentsList[position])
    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    fun setData(newCommentList: List<CommentItem>) {
        this.commentsList = newCommentList
    }
}