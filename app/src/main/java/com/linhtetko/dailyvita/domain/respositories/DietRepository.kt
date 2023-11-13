package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.domain.vos.DietVO

interface DietRepository {

    suspend fun getDiets(): List<DietVO>
}