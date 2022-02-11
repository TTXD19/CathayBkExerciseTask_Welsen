package com.android.project.cathaybkexercisetask_welsen.data.api

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import javax.inject.Inject

class GithubRemoteDataSource @Inject constructor(private val githubServiceApi: GithubServiceApi) : GithubDataSource {
    override fun getUserData(startFrom: Int, perPage: Int): LiveData<List<UserListModel>> {
        return githubServiceApi.getUserList(startFrom = startFrom, perPage = perPage)
    }
}