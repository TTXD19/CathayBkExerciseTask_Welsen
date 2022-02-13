package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment() {

    private lateinit var binding: FragmentUserDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUserDetailBinding.inflate(layoutInflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = requireArguments().getString("userName")
    }


    private fun dismiss(){
        parentFragmentManager.commit { remove(this@UserDetailFragment) }
    }
}