package com.linhtetko.dailyvita.domain.vos

import kotlinx.serialization.Serializable

@Serializable
data class BaseVO<T>(val data: T)