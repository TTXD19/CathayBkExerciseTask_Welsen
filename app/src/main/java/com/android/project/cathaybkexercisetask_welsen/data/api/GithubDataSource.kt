package com.android.project.cathaybkexercisetask_welsen.data.api

import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Single

interface GithubDataSource {
    fun getUserListData(
        startFrom: Int,
        perPage: Int
    ): Single<List<UserListModel>>

    fun getUserData(
        userName: String
    ): Single<UserDetailModel>
}