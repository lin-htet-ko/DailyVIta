package com.linhtetko.dailyvita.data.local.base

import com.linhtetko.dailyvita.domain.vos.BaseVO
import com.linhtetko.dailyvita.domain.vos.DietVO

interface LocalDietsSource {

    suspend fun getDiets(): BaseVO<List<DietVO>>
}