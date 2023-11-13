package com.linhtetko.dailyvita.data.local

import android.content.Context
import com.linhtetko.dailyvita.data.local.base.LocalAllergiesSource
import com.linhtetko.dailyvita.domain.utils.extensions.map
import com.linhtetko.dailyvita.domain.vos.AllergieVO
import com.linhtetko.dailyvita.domain.vos.BaseVO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AssetAllergiesSource @Inject constructor(
    @ApplicationContext private val context: Context,
) :
    LocalAllergiesSource {

    override suspend fun getAllegics(): BaseVO<List<AllergieVO>> {
        val result = context.map("allergies.json")
        return Json.decodeFromString(result)
    }
}