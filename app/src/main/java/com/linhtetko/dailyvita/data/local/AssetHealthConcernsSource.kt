package com.linhtetko.dailyvita.data.local

import android.content.Context
import com.linhtetko.dailyvita.data.local.base.LocalHealthConcernSource
import com.linhtetko.dailyvita.domain.utils.extensions.map
import com.linhtetko.dailyvita.domain.vos.BaseVO
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject

class AssetHealthConcernsSource @Inject constructor(
    @ApplicationContext private val context: Context,
) : LocalHealthConcernSource {

    override suspend fun getHealthConcerns(): BaseVO<List<HealthConcernVO>> {
        val result = context.map("healthconcern.json")
        return Json.decodeFromString(result)
    }
}