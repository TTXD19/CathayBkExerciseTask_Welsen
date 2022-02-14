package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.rxjava3.cachedIn
import androidx.paging.rxjava3.flowable
import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import javax.inject.Inject


class UserListPresenter @Inject constructor(
    private val githubServiceRepository: GithubServiceRepository
) : ViewModel(), UserListContract.IUserListPresenter {

    // region - Update View Implementation

    override fun getUserList(
        startFrom: Int,
        perPage: Int,
        view: UserListContract.IUserListView
    ) {
        view.onGetUserList(
            userList = Pager(
                config = PagingConfig(
                    pageSize = 20,
                    enablePlaceholders = false,
                    initialLoadSize = 20,
                    prefetchDistance = 5
                ),
                pagingSourceFactory = {
                    UserListPagingSource(
                        startFrom = startFrom,
                        githubServiceRepository = githubServiceRepository
                    )
                }
            ).flowable.cachedIn(viewModelScope))
    }

    // endregion
}