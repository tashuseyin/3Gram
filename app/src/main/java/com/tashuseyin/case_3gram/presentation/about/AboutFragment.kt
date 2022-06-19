package com.tashuseyin.case_3gram.presentation.about

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.viewbinding.ViewBinding
import com.tashuseyin.case_3gram.common.Constant
import com.tashuseyin.case_3gram.databinding.FragmentAboutBinding
import com.tashuseyin.case_3gram.presentation.BindingFragment


class AboutFragment : BindingFragment<FragmentAboutBinding>() {
    override val bindingInflater: (LayoutInflater) -> ViewBinding
        get() = FragmentAboutBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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