package com.linhtetko.dailyvita.ui.utils.extesions

import android.content.Context
import android.widget.Toast

fun Context.showToast(message: Int, duration: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, message, duration).show()
}