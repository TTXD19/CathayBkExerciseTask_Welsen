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

    // Listener
    var listener: ((String) -> Unit)? = null

    // region Diff Callback

    class DiffCallBack : DiffUtil.ItemCallback<UserListModel>() {
        override fun areItemsTheSame(oldItem: UserListModel, newItem: UserListModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: UserListModel, newItem: UserListModel): Boolean {
            return oldItem.userId == newItem.userId
        }

    }

    // endregion

    // region Override implementation

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

    // endregion

    // region View holder

    inner class UserListViewHolder(private val binding: VhUserListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: UserListModel) {

            val userName = model.userName ?: ""

            binding.tvUserName.text = model.userName
            binding.cardViewStaff.isVisible = model.isUserSiteAdmin()
            Glide.with(binding.root.context).load(model.userImageUrl).into(binding.imageUser)
            itemView.setOnClickListener { listener?.invoke(userName) }
        }
    }

    // endregion
}