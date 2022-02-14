package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel
import com.android.project.cathaybkexercisetask_welsen.data.repository.DataResult
import com.android.project.cathaybkexercisetask_welsen.data.repository.GithubServiceRepository
import com.android.project.cathaybkexercisetask_welsen.data.repository.IGithubServiceRepository
import javax.inject.Inject

class UserDetailPresenter @Inject constructor(
    private val githubServiceRepository: GithubServiceRepository
) : UserDetailContract.IUserDetailPresenter {

    // region - Update View Implementation

    override fun getUserDetail(userName: String, view: UserDetailContract.IUserDetailView) {
        githubServiceRepository.getUserDetail(
            userName = userName,
            object : IGithubServiceRepository.UserDetailCallback {
                override fun onGetUserDetail(resultData: DataResult<UserDetailModel>) {
                    if (resultData is DataResult.Success) view.onGetUserDetail(userDetail = resultData.data)
                    else view.onGetUserDetailFailed()
                }
            })
    }

    // endregion
}