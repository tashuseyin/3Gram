package com.tashuseyin.case_3gram.presentation.albums

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
class AlbumViewModel @Inject constructor(
    private val repository: Case3GramRepository
) : ViewModel() {

    private val _state: MutableStateFlow<AlbumState> = MutableStateFlow(AlbumState())
    val state: StateFlow<AlbumState> = _state


    init {
        getAlbums()
    }

    private fun getAlbums() {
        viewModelScope.launch {
            _state.value = AlbumState(isLoading = true)
            try {
                val albums = repository.getAlbums().map { it.toDomain() }
                val photos = repository.getPhotos().map { it.toDomain() }

                val albumPhotoPair = albums.map { album ->
                    album to photos.filter { photo ->
                        album.id == photo.albumId
                    }
                }
                _state.value = AlbumState(albumList = albumPhotoPair)
            } catch (e: HttpException) {
                _state.value =
                    AlbumState(errorText = e.localizedMessage ?: "An unexpected error occurred")
            } catch (e: IOException) {
                _state.value =
                    AlbumState(errorText = "Couldn't reach server. Check your internet connection.")
            }
        }
    }
}