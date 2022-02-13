package com.android.project.cathaybkexercisetask_welsen.data.api

import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(private val githubServiceApi: GithubServiceApi) : GithubDataSource {
    override fun getUserData(startFrom: Int, perPage: Int): Single<List<UserListModel>> {
        return githubServiceApi.getUserList(startFrom = startFrom, perPage = perPage).subscribeOn(Schedulers.io())
    }
}