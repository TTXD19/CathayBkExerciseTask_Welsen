package com.android.project.cathaybkexercisetask_welsen.di

import androidx.fragment.app.Fragment
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailContract
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailFragment
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListContract
import com.android.project.cathaybkexercisetask_welsen.ui.user_list.UserListFragment
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
    abstract fun bindUserDetailFragment(fragment: UserDetailFragment): UserDetailContract.IUserDetailView
}

@Module
@InstallIn(FragmentComponent::class)
class FragmentModule {

    @Provides
    fun provideUserListFragmentCallBack(fragment: Fragment): UserListFragment {
        return fragment as UserListFragment
    }

    @Provides
    fun provideUserDetailFragmentCallBack(fragment: Fragment): UserDetailFragment {
        return fragment as UserDetailFragment
    }
}