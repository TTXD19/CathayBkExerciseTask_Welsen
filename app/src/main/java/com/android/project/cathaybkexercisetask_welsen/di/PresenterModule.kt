package com.android.project.cathaybkexercisetask_welsen.di

import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailPresenter
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListPresenter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class PresenterModule {

    @Singleton
    @Provides
    fun provideUserListPresenter(githubServiceRepository: GithubServiceRepository): UserListPresenter {
        return UserListPresenter(githubServiceRepository = githubServiceRepository)
    }

    @Singleton
    @Provides
    fun provideUserDetailPresenter(githubServiceRepository: GithubServiceRepository): UserDetailPresenter {
        return UserDetailPresenter(githubServiceRepository = githubServiceRepository)
    }
}