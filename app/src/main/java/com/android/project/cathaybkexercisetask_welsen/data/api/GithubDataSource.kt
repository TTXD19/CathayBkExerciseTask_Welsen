package com.android.project.cathaybkexercisetask_welsen.data.api

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel

interface GithubDataSource {
    fun getUserData(
        startFrom: Int,
        perPage: Int
    ): LiveData<List<UserListModel>>
}