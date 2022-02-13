package com.android.project.cathaybkexercisetask_welsen.data.repository

import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel

interface IGithubServiceRepository {

    interface UserListCallback {
        fun onGetResult(list: List<UserListModel>)
    }

    fun getUserList(
        startFrom: Int,
        perPage: Int,
        userListCallback: UserListCallback
    )
}