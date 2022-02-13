package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.databinding.VhUserListBinding
import com.bumptech.glide.Glide

class UserListAdapter : PagingDataAdapter<UserListModel, UserListAdapter.UserListViewHolder>(DiffCallBack()) {

    var listener: ((String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListViewHolder {
        return UserListViewHolder(
            VhUserListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserListViewHolder, position: Int) {
        getItem(position)?.also { holder.bind(model = it) }
    }


    inner class UserListViewHolder(private val binding: VhUserListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UserListModel) {

            val userName = model.userName ?: ""

            binding.tvUserName.text = model.userName
            binding.cardViewStaff.isVisible = model.isUserSiteAdmin()
            Glide.with(binding.root.context).load(model.userImageUrl).into(binding.imageUser)
            itemView.setOnClickListener { listener?.invoke(userName) }
        }
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