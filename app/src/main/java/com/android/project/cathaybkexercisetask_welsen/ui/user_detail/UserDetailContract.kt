package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel

class UserDetailContract {
    interface IUserDetailPresenter {
        fun getUserDetail(userName: String, view: IUserDetailView)
    }

    interface IUserDetailView {
        fun onGetUserDetail(userDetail: UserDetailModel)
        fun onGetUserDetailFailed()
    }
}