package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.data.local.base.LocalDietsSource
import com.linhtetko.dailyvita.domain.vos.DietVO
import javax.inject.Inject

class DietRepoImpl @Inject constructor(private val localDietsSource: LocalDietsSource) :
    DietRepository {

    override suspend fun getDiets(): List<DietVO> {
        return localDietsSource.getDiets().data
    }
}