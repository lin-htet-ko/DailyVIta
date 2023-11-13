package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.data.local.base.LocalHealthConcernSource
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO
import javax.inject.Inject

class HealthConcernRepoImpl @Inject constructor(
    private val localHealthConcernSource: LocalHealthConcernSource
): HealthConcernRepository {

    override suspend fun getHealthConcerns(): List<HealthConcernVO> {
        return localHealthConcernSource.getHealthConcerns().data
    }
}