package com.tashuseyin.case_3gram.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.tashuseyin.case_3gram.MainActivity
import com.tashuseyin.case_3gram.R
import com.tashuseyin.case_3gram.databinding.FragmentAlbumsBinding
import com.tashuseyin.case_3gram.presentation.BindingFragment
import com.tashuseyin.case_3gram.presentation.SharedViewModel
import com.tashuseyin.case_3gram.presentation.albums.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AlbumsFragment : BindingFragment<FragmentAlbumsBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAlbumsBinding::inflate

    private val sharedViewModel: SharedViewModel by viewModels()
    private val albumViewModel: AlbumViewModel by viewModels()
    private val albumAdapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbarTitle()
        observeUI()
    }

    private fun setToolbarTitle() {
        lifecycleScope.launch {
            sharedViewModel.readToolbarTitleState().observe(viewLifecycleOwner) {
                if (it) {
                    (activity as MainActivity).toolbarTitleChange(getString(R.string.albums))
                }
            }
        }
    }

    private fun observeUI() {
        lifecycleScope.launch {
            albumViewModel.state.collect { state ->
                binding.progressbar.isVisible = state.isLoading
                if (state.errorText.isNotBlank()) {
                    binding.errorText.text = state.errorText
                }
                if (state.albumList.isNotEmpty()) {
                    albumAdapter.setData(state.albumList)
                    binding.recyclerview.adapter = albumAdapter
                }
            }
        }
    }
}