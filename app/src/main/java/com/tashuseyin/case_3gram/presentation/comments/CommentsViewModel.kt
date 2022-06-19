package com.tashuseyin.case_3gram.presentation.comments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tashuseyin.case_3gram.data.toDomain
import com.tashuseyin.case_3gram.domain.repository.Case3GramRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(
    private val repository: Case3GramRepository
) : ViewModel() {

    private val _state: MutableStateFlow<CommentsState> = MutableStateFlow(CommentsState())
    val state: StateFlow<CommentsState> = _state

    init {
        getComments()
    }

    private fun getComments() {
        viewModelScope.launch {
            _state.value = CommentsState(isLoading = true)
            try     {
                val response = repository.getComments().map { it.toDomain() }
                _state.value = CommentsState(commentsList = response)
            } catch (e: HttpException) {
                _state.value =
                    CommentsState(errorText = e.localizedMessage ?: "An unexpected error occurred")
            } catch (e: IOException) {
                _state.value =
                    CommentsState(errorText = "Couldn't reach server. Check your internet connection.")
            }
        }
    }
}