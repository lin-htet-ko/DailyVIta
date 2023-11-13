package com.linhtetko.dailyvita.data.di

import com.linhtetko.dailyvita.data.local.AssetAllergiesSource
import com.linhtetko.dailyvita.data.local.AssetDietSource
import com.linhtetko.dailyvita.data.local.AssetHealthConcernsSource
import com.linhtetko.dailyvita.data.local.base.LocalAllergiesSource
import com.linhtetko.dailyvita.data.local.base.LocalDietsSource
import com.linhtetko.dailyvita.data.local.base.LocalHealthConcernSource
import com.linhtetko.dailyvita.domain.respositories.HealthConcernRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface LocalModule {

    @Binds
    @Singleton
    fun bindAllergiesSource(impl: AssetAllergiesSource): LocalAllergiesSource

    @Binds
    @Singleton
    fun bindDietsSource(impl: AssetDietSource): LocalDietsSource

    @Binds
    @Singleton
    fun bindHealthConcernsSource(impl: AssetHealthConcernsSource): LocalHealthConcernSource
}