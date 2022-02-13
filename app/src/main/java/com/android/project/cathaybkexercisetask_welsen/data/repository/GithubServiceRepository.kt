package com.android.project.cathaybkexercisetask_welsen.data.repository

import com.android.project.cathaybkexercisetask_welsen.data.api.GithubRemoteDataSource
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class GithubServiceRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : IGithubServiceRepository {
    override fun getUserList(
        startFrom: Int,
        perPage: Int,
        userListCallback: IGithubServiceRepository.UserListCallback
    ) {
        githubRemoteDataSource.getUserListData(startFrom = startFrom, perPage = perPage)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { userListCallback.onGetResult(list = it) }
    }

    override fun getUserDetail(userName: String, userDetailCallback: IGithubServiceRepository.UserDetailCallback) {
        githubRemoteDataSource.getUserData(userName = userName)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy { userDetailCallback.onGetUserDetail(data = it) }
    }
}