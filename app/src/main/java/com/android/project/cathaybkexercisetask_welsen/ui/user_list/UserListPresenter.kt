package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.util.Log
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import com.android.project.cathaybkexercisetask_welsen.data.repository.IGithubServiceRepository
import javax.inject.Inject


class UserListPresenter @Inject constructor(
    private val githubServiceRepository: GithubServiceRepository
) : UserListContract.IUserListPresenter {

    override fun getUserList(
        startFrom: Int,
        perPage: Int,
        view: UserListContract.IUserListView
    ) {
        githubServiceRepository.getUserList(
            startFrom = startFrom,
            perPage = perPage,
            userListCallback = object : IGithubServiceRepository.UserListCallback {
                override fun onGetResult(list: List<UserListModel>) {
                    Log.d("TestData", "success")
                    view.onGetUserList(userList = list)
                }
            })
    }
}