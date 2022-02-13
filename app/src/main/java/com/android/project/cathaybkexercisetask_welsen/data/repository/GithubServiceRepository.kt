package com.android.project.cathaybkexercisetask_welsen.data.repository

import com.android.project.cathaybkexercisetask_welsen.data.api.GithubRemoteDataSource
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
        githubRemoteDataSource.getUserData(startFrom = startFrom, perPage = perPage).subscribeBy {
            userListCallback.onGetResult(list = it)
        }
    }
}