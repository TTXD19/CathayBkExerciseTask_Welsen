package com.android.project.cathaybkexercisetask_welsen.data.repository

import com.android.project.cathaybkexercisetask_welsen.data.api.GithubRemoteDataSource
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

class GithubServiceRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : IGithubServiceRepository {
    override fun getUserList(
        startFrom: Int,
        perPage: Int,
    ): Single<List<UserListModel>> {
        return githubRemoteDataSource
            .getUserListData(startFrom = startFrom, perPage = perPage)
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getUserDetail(userName: String, userDetailCallback: IGithubServiceRepository.UserDetailCallback) {
        githubRemoteDataSource.getUserData(userName = userName)
            .observeOn(AndroidSchedulers.mainThread())
            .mapToResult()
            .subscribeBy { userDetailCallback.onGetUserDetail(resultData = it) }
    }

    private fun <T> Single<T>.mapToResult(): Single<DataResult<T>> {
        return map<DataResult<T>> { DataResult.Success(it) }
            .onErrorReturn { DataResult.Failure() }
    }
}