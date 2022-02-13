package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.*
import androidx.paging.LoadState
import androidx.paging.PagingData
import com.android.project.cathaybkexercisetask_welsen.R
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserListBinding
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailFragment
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

@AndroidEntryPoint
class UserListFragment : Fragment(), UserListContract.IUserListView {

    private lateinit var binding: FragmentUserListBinding

    @Inject
    lateinit var userListPresenter: UserListPresenter

    private val userListAdapter: UserListAdapter by lazy { UserListAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUserListBinding.inflate(layoutInflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userListPresenter.getUserList(startFrom = 0, perPage = 20, view = this)
        initRecyclerView()
        initBtnRetry()
    }

    override fun onGetUserList(userList: Flowable<PagingData<UserListModel>>) {
        userList.subscribeBy { userListAdapter.submitData(lifecycle, it) }
    }

    private fun navigateToUserDetail(name: String) {
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<UserDetailFragment>(R.id.fl_main, args = bundleOf("userName" to name))
        }
    }

    private fun initRecyclerView() {
        binding.recyclerViewUserList
            .apply { userListAdapter.listener = { userName -> navigateToUserDetail(name = userName) } }
            .apply {
                userListAdapter.addLoadStateListener {
                    when (it.source.refresh) {
                        is LoadState.NotLoading -> {
                            updateLoadingVisibility(isVisible = false)
                            updateErrorMessageVisibility(isVisible = false)
                            updateBtnRetryVisibility(isVisible = false)
                        }
                        is LoadState.Loading -> {
                            updateLoadingVisibility(isVisible = true)
                            updateErrorMessageVisibility(isVisible = false)
                            updateBtnRetryVisibility(isVisible = false)
                        }
                        is LoadState.Error -> {
                            updateLoadingVisibility(isVisible = false)
                            updateErrorMessageVisibility(isVisible = true)
                            updateBtnRetryVisibility(isVisible = true)
                        }
                    }
                }
            }
            .apply {
                adapter = userListAdapter.withLoadStateFooter(UserListLoadStateAdapter { userListAdapter.retry() })
            }
    }

    private fun updateLoadingVisibility(isVisible: Boolean) {
        binding.progressBar.isVisible = isVisible
    }

    private fun updateErrorMessageVisibility(isVisible: Boolean) {
        binding.tvErrorMessage.isVisible = isVisible
    }

    private fun initBtnRetry() {
        binding.btnRetry.setOnClickListener { userListAdapter.refresh() }
    }

    private fun updateBtnRetryVisibility(isVisible: Boolean) {
        binding.btnRetry.isVisible = isVisible
    }
}