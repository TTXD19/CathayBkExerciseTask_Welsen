package com.android.project.cathaybkexercisetask_welsen.di

import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailContract
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailPresenter
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListContract
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListPresenter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@InstallIn(FragmentComponent::class)
@Module
abstract class PresenterModule {

    @Binds
    abstract fun bindUserListPresenter(presenter: UserListPresenter): UserListContract.IUserListPresenter

    @Binds
    abstract fun bindUserDetailPresenter(presenter: UserDetailPresenter): UserDetailContract.IUserDetailPresenter
}