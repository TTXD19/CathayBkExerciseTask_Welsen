package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.project.cathaybkexercisetask_welsen.R
import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment : DialogFragment(), UserDetailContract.IUserDetailView {

    private lateinit var binding: FragmentUserDetailBinding

    @Inject
    lateinit var userDetailPresenter: UserDetailPresenter

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
        name?.also { userDetailPresenter.getUserDetail(userName = it, view = this) }
        initCloseButton()
    }

    private fun initCloseButton() {
        binding.imageClose.setOnClickListener {
            parentFragmentManager.commit {
                remove(this@UserDetailFragment)
            }
        }
    }


    override fun onGetUserDetail(userDetail: UserDetailModel) {
        binding.tvUserRealName.text = userDetail.userRealName
        binding.tvUserGitName.text = userDetail.userGitName
        binding.tvUserBio.text = userDetail.userBio
        binding.tvUserLocation.text = userDetail.userLocation
        binding.tvUserLink.text = userDetail.userBlogSite
        context?.also { Glide.with(it).load(userDetail.userImageUrl).into(binding.imageUser) }
        binding.cardViewStaff.isVisible = userDetail.isUserSiteAdmin()
    }
}