package com.linhtetko.dailyvita.domain.vos

import kotlinx.serialization.Serializable

@Serializable
data class HealthConcernVO(
    val id: Int,
    val name: String,

    val isSelected: Boolean = false,
)