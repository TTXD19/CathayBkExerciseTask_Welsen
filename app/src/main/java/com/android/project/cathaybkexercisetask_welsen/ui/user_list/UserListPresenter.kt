package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import javax.inject.Inject

class UserListPresenter @Inject constructor(private val githubServiceRepository: GithubServiceRepository) :
    UserListContract.IUserListPresenter {
    override fun getUserList(
        startFrom: Int,
        perPage: Int
    ): LiveData<List<UserListModel>> {
        return githubServiceRepository.getUserList(startFrom = startFrom, perPage = perPage)
    }
}