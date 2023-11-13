package com.linhtetko.dailyvita.domain.vos


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DietVO(
    val id: Int,
    val name: String,
    @SerialName("tool_tip")
    val toolTip: String,

    val isSelected: Boolean = false,
    val showTooltip: Boolean = false
)