package com.tashuseyin.case_3gram.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tashuseyin.case_3gram.data.data_store.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {

    fun saveToolbarTitleState(state: Boolean) {
        viewModelScope.launch {
            dataStoreRepository.saveToolbarTitleState(state)
        }
    }
    fun readToolbarTitleState() = dataStoreRepository.readToolbarTitleState.asLiveData()
}