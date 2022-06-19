package com.tashuseyin.case_3gram.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tashuseyin.case_3gram.common.Resource
import com.tashuseyin.case_3gram.domain.use_case.get_comments.GetCommentsUseCase
import com.tashuseyin.case_3gram.presentation.albums.AlbumState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val getCommentsUseCase: GetCommentsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<CommentsState> = MutableStateFlow(CommentsState())
    val state: StateFlow<CommentsState> = _state

    init {
        getComments()
    }

    private fun getComments() {
        getCommentsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CommentsState(commentsList = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = CommentsState(isLoading = true)
                }
                is Resource.Error -> {
                    AlbumState(errorText = result.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

}