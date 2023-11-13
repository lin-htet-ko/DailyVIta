package com.linhtetko.dailyvita.domain.vos


import kotlinx.serialization.Serializable

@Serializable
data class AllergieVO(
    val id: Int,
    val name: String
)