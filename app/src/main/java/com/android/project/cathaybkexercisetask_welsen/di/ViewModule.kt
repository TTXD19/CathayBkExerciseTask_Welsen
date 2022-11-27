package com.android.project.cathaybkexercisetask_welsen.di

import androidx.fragment.app.Fragment
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListContract
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListFragment
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListPresenter
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
abstract class ViewModule {
    @Binds
    abstract fun bindUserListFragment(fragment: UserListFragment): UserListContract.IUserListView

    @Binds
    abstract fun bindUserListPresenter(presenter: UserListPresenter): UserListContract.IUserListPresenter
}

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    fun provideUserListFragmentCallBack(fragment: Fragment): UserListFragment{
        return fragment as UserListFragment
    }
}