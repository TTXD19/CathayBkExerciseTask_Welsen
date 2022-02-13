package com.android.project.cathaybkexercisetask_welsen.data.repository

import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Single

interface IGithubServiceRepository {

    fun getUserList(
        startFrom: Int,
        perPage: Int,
    ): Single<List<UserListModel>>

    interface UserDetailCallback {
        fun onGetUserDetail(resultData: DataResult<UserDetailModel>)
    }

    fun getUserDetail(
        userName: String,
        userDetailCallback: UserDetailCallback
    )
}