package com.android.project.cathaybkexercisetask_welsen.di

import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import com.android.project.cathaybkexercisetask_welsen.data.repository.IGithubServiceRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindGithubServiceRepository(githubServiceRepository: GithubServiceRepository): IGithubServiceRepository
}