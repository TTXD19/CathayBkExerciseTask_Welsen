package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import androidx.paging.PagingData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Flowable

class UserListContract {

    // region - Data

    interface IUserListPresenter {
        fun getUserList(startFrom: Int, perPage: Int, view: IUserListView)
    }

    // endregion

    // region - View

    interface IUserListView {
        fun onGetUserList(userList: Flowable<PagingData<UserListModel>>)
    }

    // endregion
}