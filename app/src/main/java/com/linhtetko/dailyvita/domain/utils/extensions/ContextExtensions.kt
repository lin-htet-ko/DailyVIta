package com.linhtetko.dailyvita.domain.utils.extensions

import android.content.Context

suspend fun Context.map(fileName: String) = assets.open(fileName)
    .use { it.bufferedReader().readText() }