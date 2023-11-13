package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.data.local.base.LocalAllergiesSource
import com.linhtetko.dailyvita.domain.vos.AllergieVO
import javax.inject.Inject

class AllegicRepoImpl @Inject constructor(
    private val localAllegicSource: LocalAllergiesSource
) :
    AllegicRepository {

    override suspend fun getAllegics(): List<AllergieVO> {
        return localAllegicSource.getAllegics().data
    }
}