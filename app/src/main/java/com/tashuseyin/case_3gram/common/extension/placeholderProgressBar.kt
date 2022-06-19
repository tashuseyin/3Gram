package com.tashuseyin.case_3gram.common.extension


import android.content.Context
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.tashuseyin.case_3gram.R

fun placeholderProgressBar(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        setColorSchemeColors(R.color.white)
        start()
    }
}