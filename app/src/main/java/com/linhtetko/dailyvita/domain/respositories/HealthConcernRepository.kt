package com.linhtetko.dailyvita.domain.respositories

import com.linhtetko.dailyvita.domain.vos.HealthConcernVO

interface HealthConcernRepository {

    suspend fun getHealthConcerns(): List<HealthConcernVO>
}