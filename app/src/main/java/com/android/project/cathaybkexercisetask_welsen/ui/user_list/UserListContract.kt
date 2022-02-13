package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel

class UserListContract {
    interface IUserListPresenter{
        fun getUserList(startFrom: Int, perPage: Int, view: IUserListView)
    }
    interface IUserListView{
        fun onGetUserList(userList: List<UserListModel>)
    }
}