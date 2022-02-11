package com.android.project.cathaybkexercisetask_welsen.di

import com.android.project.cathaybkexercisetask_welsen.data.api.GithubRemoteDataSource
import com.android.project.cathaybkexercisetask_welsen.data.api.GithubServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DataSourceModule {

    @Singleton
    @Provides
    fun provideDataSourceModule(githubServiceApi: GithubServiceApi): GithubRemoteDataSource {
        return GithubRemoteDataSource(githubServiceApi = githubServiceApi)
    }
}