package com.linhtetko.dailyvita.domain.di

import com.linhtetko.dailyvita.domain.respositories.AllegicRepoImpl
import com.linhtetko.dailyvita.domain.respositories.AllegicRepository
import com.linhtetko.dailyvita.domain.respositories.DietRepoImpl
import com.linhtetko.dailyvita.domain.respositories.DietRepository
import com.linhtetko.dailyvita.domain.respositories.HealthConcernRepoImpl
import com.linhtetko.dailyvita.domain.respositories.HealthConcernRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {

    @Binds
    @Singleton
    fun bindAllergicRepo(impl: AllegicRepoImpl): AllegicRepository

    @Binds
    @Singleton
    fun bindDietRepo(impl: DietRepoImpl): DietRepository

    @Binds
    fun bindHealthConcernRepo(impl: HealthConcernRepoImpl): HealthConcernRepository

}