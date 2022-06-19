package com.tashuseyin.case_3gram.presentation.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.viewbinding.ViewBinding
import com.tashuseyin.case_3gram.MainActivity
import com.tashuseyin.case_3gram.R
import com.tashuseyin.case_3gram.common.Constant
import com.tashuseyin.case_3gram.databinding.FragmentAboutBinding
import com.tashuseyin.case_3gram.presentation.BindingFragment
import com.tashuseyin.case_3gram.presentation.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BindingFragment<FragmentAboutBinding>() {

    private val sharedViewModel: SharedViewModel by viewModels()

    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAboutBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel.saveToolbarTitleState(true)
        (activity as MainActivity).toolbarTitleChange(getString(R.string.about))
        setListener()
    }

    private fun setListener() {
        binding.apply {
            facebookLogo.setOnClickListener {
                goToUrl(Constant.FACEBOOK)
            }
            gitlabLogo.setOnClickListener {
                goToUrl(Constant.GITLAB)
            }
            githubLogo.setOnClickListener {
                goToUrl(Constant.GITHUB)
            }
            messageLogo.setOnClickListener {
                goToUrl(Constant.MESSAGE)
            }
            instagramLogo.setOnClickListener {
                goToUrl(Constant.INSTAGRAM)
            }
            figmaLogo.setOnClickListener {
                goToUrl(Constant.FIGMA)
            }
        }
    }

    private fun goToUrl(url: String) {
        val uri = Uri.parse(url)
        startActivity(Intent(Intent.ACTION_VIEW, uri))
    }
}