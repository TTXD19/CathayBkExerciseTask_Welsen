package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel

class UserListContract {
    interface IUserListPresenter{
        fun getUserList(startFrom: Int, perPage: Int): LiveData<List<UserListModel>>
    }
    interface IUserListView{
        fun onGetUserList(userList: List<UserListModel>)
    }
}