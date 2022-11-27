package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel

class UserDetailContract {

    // region - Data

    interface IUserDetailPresenter {
        fun getUserDetail(userName: String)
    }

    // endregion

    // region - View

    interface IUserDetailView {
        fun onGetUserDetail(userDetail: UserDetailModel)
        fun onGetUserDetailFailed()
    }

    // endregion
}