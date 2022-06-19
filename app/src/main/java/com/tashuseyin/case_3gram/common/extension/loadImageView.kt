package com.tashuseyin.case_3gram.common.extension

import android.widget.ImageView
import coil.load

fun ImageView.loadImageView(url: String?) {
    load(url) {
        crossfade(300)
    }
}