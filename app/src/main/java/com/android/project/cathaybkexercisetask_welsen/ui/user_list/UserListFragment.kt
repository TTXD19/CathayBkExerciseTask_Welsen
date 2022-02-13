package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.*
import com.android.project.cathaybkexercisetask_welsen.R
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserListBinding
import com.android.project.cathaybkexercisetask_welsen.ui.user_detail.UserDetailFragment
import dagger.hilt.android.AndroidEntryPoint
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
    }

    override fun onGetUserList(userList: List<UserListModel>) {
        binding.recyclerViewUserList
            .apply { userListAdapter.listener = { userName -> navigateToUserDetail(name = userName) } }
            .apply { adapter = userListAdapter }
            .also { userListAdapter.submitList(userList) }
        Log.d("TestData", "successUI")
    }

    private fun navigateToUserDetail(name: String) {
        Log.d("TestData", "Change")
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            add<UserDetailFragment>(R.id.fl_main, args = bundleOf("userName" to name))
        }
    }
}