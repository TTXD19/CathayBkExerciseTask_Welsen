package com.android.project.cathaybkexercisetask_welsen.data.repository

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.api.GithubRemoteDataSource
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import javax.inject.Inject

class GithubServiceRepository @Inject constructor(
    private val githubRemoteDataSource: GithubRemoteDataSource
) : IGithubServiceRepository {
    override fun getUserList(startFrom: Int, perPage: Int): LiveData<List<UserListModel>> {
        return githubRemoteDataSource.getUserData(startFrom = startFrom, perPage = perPage)
    }
}