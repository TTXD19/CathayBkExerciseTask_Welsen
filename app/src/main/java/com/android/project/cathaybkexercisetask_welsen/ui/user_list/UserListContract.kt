package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.content.Context
import androidx.paging.PagingData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Flowable

class UserListContract {

    // region - Data

    interface IUserListPresenter {
        fun getUserList(startFrom: Int, perPage: Int)
        fun getUserList(context: Context)
    }

    // endregion

    // region - View

    interface IUserListView {
        fun onGetUserList(userList: Flowable<PagingData<UserListModel>>)
        fun onGetUserList(userList: List<UserListModel>)
    }

    // endregion
}