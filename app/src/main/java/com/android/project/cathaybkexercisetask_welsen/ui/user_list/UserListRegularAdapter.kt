package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.databinding.VhUserListBinding

class UserListRegularAdapter : ListAdapter<UserListModel, UserListViewHolder>(DiffCallBack()) {

    // Listener
    var listener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            VhUserListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position)?.also { holder.bind(model = it, listener) }
    }

    class DiffCallBack : DiffUtil.ItemCallback<UserListModel>() {
        override fun areItemsTheSame(oldItem: UserListModel, newItem: UserListModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserListModel, newItem: UserListModel): Boolean {
            return oldItem.userId == newItem.userId
        }
    }
}