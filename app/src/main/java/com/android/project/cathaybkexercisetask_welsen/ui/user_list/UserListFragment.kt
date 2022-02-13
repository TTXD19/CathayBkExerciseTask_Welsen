package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserListBinding
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
            .apply { adapter = userListAdapter }
            .also { userListAdapter.submitList(userList) }
        Log.d("TestData", "successUI")
    }
}