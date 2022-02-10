package com.android.project.cathaybkexercisetask_welsen.ui.user_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserListBinding

class UserListFragment : Fragment() {

    private lateinit var binding: FragmentUserListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUserListBinding.inflate(layoutInflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}