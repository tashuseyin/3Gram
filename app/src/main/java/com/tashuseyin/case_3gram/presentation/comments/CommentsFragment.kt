package com.tashuseyin.case_3gram.presentation.comments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.tashuseyin.case_3gram.MainActivity
import com.tashuseyin.case_3gram.R
import com.tashuseyin.case_3gram.common.extension.hideKeyboard
import com.tashuseyin.case_3gram.databinding.FragmentCommentsBinding
import com.tashuseyin.case_3gram.presentation.BindingFragment
import com.tashuseyin.case_3gram.presentation.comments.adapter.CommentsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CommentsFragment : BindingFragment<FragmentCommentsBinding>() {
    private val commentsViewModel: CommentsViewModel by viewModels()
    private lateinit var alertDialog: AlertDialog.Builder
    private val adapter = CommentsAdapter()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentCommentsBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).toolbarTitleChange(getString(R.string.comments))
        observeUI()
        setAlertDialog()
    }

    private fun observeUI() {
        lifecycleScope.launch {
            commentsViewModel.state.collect { state ->
                binding.apply {
                    progressbar.isVisible = state.isLoading
                    if (state.errorText.isNotBlank()) {
                        errorText.text = state.errorText
                    }
                    if (state.commentsList.isNotEmpty()) {
                        adapter.setData(state.commentsList)
                        recyclerview.adapter = adapter
                    }
                }
            }
        }
    }

    private fun validateComment(): Boolean {
        return when {
            TextUtils.isEmpty(binding.commentEditText.text.toString().trim { it <= ' ' }) -> {
                false
            }
            else -> {
                true
            }
        }
    }

    private fun setAlertDialog() {
        binding.sendButton.setOnClickListener {
            hideKeyboard(it)
            if (validateComment()) {
                binding.progressbar.isVisible = true
                lifecycleScope.launch {
                    delay(1000)
                    binding.progressbar.isVisible = false
                    createAlertDialog("Your comment has been successfully saved.")
                    alertDialog.show()
                }
            } else {
                createAlertDialog("Your comment cannot be empty.")
                alertDialog.show()
            }
        }
    }

    private fun createAlertDialog(message: String) {
        alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Comment Status")
        alertDialog.setMessage(message)
        alertDialog.setIcon(R.drawable.ic_comment)
        alertDialog.setPositiveButton("OK") { _, _ -> }.create()
    }

}