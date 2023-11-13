package com.linhtetko.dailyvita.data.local.base

import com.linhtetko.dailyvita.domain.vos.AllergieVO
import com.linhtetko.dailyvita.domain.vos.BaseVO

interface LocalAllergiesSource {

    suspend fun getAllegics(): BaseVO<List<AllergieVO>>
}