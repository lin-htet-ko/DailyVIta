package com.linhtetko.dailyvita.domain.utils

interface JsonParser {

    fun <T> fromJson(json: String): T?

    fun <T> toJson(data: T): String

}