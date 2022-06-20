package com.tashuseyin.case_3gram.common

import android.app.Activity
import android.app.AlertDialog
import com.tashuseyin.case_3gram.R


class LoadingDialog(private val activity: Activity) {
    private var dialog: AlertDialog? = null

    fun startLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.custom_loading_dialog, null))
        builder.setCancelable(true)

        dialog = builder.create()
        dialog?.show()
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }

}