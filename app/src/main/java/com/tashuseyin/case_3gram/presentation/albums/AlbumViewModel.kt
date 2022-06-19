package com.tashuseyin.case_3gram.presentation.albums

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tashuseyin.case_3gram.common.Resource
import com.tashuseyin.case_3gram.domain.use_case.get_albums.GetAlbumsUseCase
import com.tashuseyin.case_3gram.domain.use_case.get_photos.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(
    private val getAlbumsUseCase: GetAlbumsUseCase,
    private val getPhotosUseCase: GetPhotosUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<AlbumState> = MutableStateFlow(AlbumState())
    val state: StateFlow<AlbumState> = _state


    init {
        getAlbums()
        getPhotos()
    }

    private fun getAlbums() {
        getAlbumsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AlbumState(albumList = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = AlbumState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value =
                        AlbumState(errorText = result.message ?: "An unexcepted error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getPhotos() {
        getPhotosUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = AlbumState(photoList = result.data ?: emptyList())
                }
                is Resource.Loading -> {
                    _state.value = AlbumState(isLoading = true)
                }
                is Resource.Error -> {
                    _state.value =
                        AlbumState(errorText = result.message ?: "An unexcepted error occurred")
                }
            }
        }.launchIn(viewModelScope)
    }
}