package com.android.project.cathaybkexercisetask_welsen.data.repository

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel

interface IGithubServiceRepository {
    fun getUserList(
        startFrom: Int,
        perPage: Int
    ): LiveData<List<UserListModel>>
}