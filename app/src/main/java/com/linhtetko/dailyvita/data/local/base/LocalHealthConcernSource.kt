package com.linhtetko.dailyvita.data.local.base

import com.linhtetko.dailyvita.domain.vos.BaseVO
import com.linhtetko.dailyvita.domain.vos.HealthConcernVO

interface LocalHealthConcernSource {

    suspend fun getHealthConcerns(): BaseVO<List<HealthConcernVO>>

}