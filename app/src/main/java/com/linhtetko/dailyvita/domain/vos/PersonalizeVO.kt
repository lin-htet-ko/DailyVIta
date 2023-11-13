package com.linhtetko.dailyvita.domain.vos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonalizeVO(
    @SerialName("health_concerns")
    val healthConcerns: List<HealthConcernVO> = listOf(),
    val diets: List<DietVO> = listOf(),
    @SerialName("is_daily_exposure")
    val isDailyExposure: Boolean,
    @SerialName("is_somke")
    val isSmoke: Boolean,
    val alchol: String,
    val allergies: List<AllergieVO> = listOf()
)
