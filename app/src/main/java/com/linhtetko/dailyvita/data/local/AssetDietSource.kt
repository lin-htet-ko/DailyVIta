package com.linhtetko.dailyvita.data.local

import android.content.Context
import com.linhtetko.dailyvita.data.local.base.LocalDietsSource
import com.linhtetko.dailyvita.domain.utils.JsonParser
import com.linhtetko.dailyvita.domain.utils.extensions.map
import com.linhtetko.dailyvita.domain.vos.BaseVO
import com.linhtetko.dailyvita.domain.vos.DietVO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AssetDietSource @Inject constructor(
    @ApplicationContext private val context: Context,
): LocalDietsSource {

    override suspend fun getDiets(): BaseVO<List<DietVO>> {
        val result = context.map("diets.json")
        return Json.decodeFromString(result)
    }
}