package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.android.project.cathaybkexercisetask_welsen.databinding.VhUserListLoadStateBinding

class UserListLoadStateAdapter(private val retryListener: (() -> Unit)) :
    LoadStateAdapter<UserListLoadStateAdapter.LoadStateViewHolder>() {

    // region Override implementation

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): LoadStateViewHolder {
        return LoadStateViewHolder(
            VhUserListLoadStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: LoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    // endregion

    // region View holder

    inner class LoadStateViewHolder(private val binding: VhUserListLoadStateBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(loadState: LoadState) {
            when (loadState) {
                is LoadState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.tvErrorMessage.visibility = View.GONE
                    binding.btnRetry.visibility = View.GONE
                }
                is LoadState.NotLoading -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.GONE
                    binding.btnRetry.visibility = View.GONE
                }
                is LoadState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    binding.tvErrorMessage.visibility = View.VISIBLE
                    binding.btnRetry.visibility = View.VISIBLE
                }
            }
            binding.btnRetry.setOnClickListener {
                retryListener.invoke()
            }
        }
    }

    // endregion
}