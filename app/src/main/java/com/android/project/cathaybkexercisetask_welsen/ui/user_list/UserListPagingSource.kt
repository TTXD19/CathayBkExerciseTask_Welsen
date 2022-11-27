package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import androidx.paging.PagingState
import androidx.paging.rxjava3.RxPagingSource
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.data.repository.IGithubServiceRepository
import io.reactivex.rxjava3.core.Single

class UserListPagingSource(
    private val startFrom: Int,
    private val githubServiceRepository: IGithubServiceRepository
) : RxPagingSource<Int, UserListModel>() {

    // region Override implementation

    override fun getRefreshKey(state: PagingState<Int, UserListModel>): Int? = null

    override fun loadSingle(params: LoadParams<Int>): Single<LoadResult<Int, UserListModel>> {
        val initialKey = params.key ?: startFrom
        return githubServiceRepository.getUserList(startFrom = initialKey, perPage = 20)
            .map { toLoadResult(key = initialKey, it) }
            .onErrorReturn { LoadResult.Error(it) }
    }

    // endregion

    // region View - Load Result Mapping

    private fun toLoadResult(key: Int, userList: List<UserListModel>): LoadResult<Int, UserListModel> {
        val nextKey = userList.lastOrNull()?.userId?.toInt() ?: key
        return LoadResult.Page(
            data = userList,
            prevKey = null,
            nextKey = nextKey
        )
    }

    // endregion


}