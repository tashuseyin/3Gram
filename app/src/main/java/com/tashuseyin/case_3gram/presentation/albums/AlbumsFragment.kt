package com.tashuseyin.case_3gram.presentation.albums

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.tashuseyin.case_3gram.MainActivity
import com.tashuseyin.case_3gram.R
import com.tashuseyin.case_3gram.databinding.FragmentAlbumsBinding
import com.tashuseyin.case_3gram.presentation.albums.adapter.HomeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class AlbumsFragment : Fragment() {
    private var _binding: FragmentAlbumsBinding? = null
    private val binding get() = _binding!!

    private val albumViewModel: AlbumViewModel by viewModels()
    private val albumAdapter = HomeAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAlbumsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeUI()
    }

    private fun observeUI() {
        lifecycleScope.launch {
            albumViewModel.state.collect { state ->
                binding.progressbar.isVisible = state.isLoading
                if (state.errorText.isNotBlank()) {
                    binding.errorText.text = state.errorText
                }
                if (state.photoList.isNotEmpty() && state.albumList.isNotEmpty()) {
                    state.albumList.forEach { albumItem ->
                        albumAdapter.setData(state.albumList, state.photoList.filter { photoItem ->
                            albumItem.id == photoItem.albumId
                        })
                    }
                    binding.recyclerview.adapter = albumAdapter
                }
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}