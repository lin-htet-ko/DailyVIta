package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.domain.vos.AllergieVO

interface AllegicRepository {

    suspend fun getAllegics(): List<AllergieVO>
}