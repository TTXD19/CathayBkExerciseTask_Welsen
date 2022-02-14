package com.android.project.cathaybkexercisetask_welsen.ui.user_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import com.android.project.cathaybkexercisetask_welsen.data.model.UserDetailModel
import com.android.project.cathaybkexercisetask_welsen.databinding.FragmentUserDetailBinding
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserDetailFragment : DialogFragment(), UserDetailContract.IUserDetailView {

    // View Binding
    private lateinit var binding: FragmentUserDetailBinding

    // Presenter
    @Inject
    lateinit var userDetailPresenter: UserDetailPresenter

    // Data Key
    private var userName: String? = null

    // region Life cycle

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentUserDetailBinding.inflate(layoutInflater, container, false)
        .also { binding = it }
        .root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userName = requireArguments().getString("userName")
        updateLoadingVisibility(isVisible = true)
        initUserData()
        initBtnRetry()
        initCloseButton()
    }

    // endregion

    // region - View Init

    private fun initUserData() {
        userName?.also { userDetailPresenter.getUserDetail(userName = it, view = this) }
    }

    private fun initCloseButton() {
        binding.imageClose.setOnClickListener {
            parentFragmentManager.commit {
                remove(this@UserDetailFragment)
            }
        }
    }

    private fun initBtnRetry() {
        binding.btnRetry.setOnClickListener {
            updateLoadingVisibility(isVisible = true)
            initUserData()
        }
    }

    // endregion

    // region - View Update

    override fun onGetUserDetail(userDetail: UserDetailModel) {
        binding.tvUserRealName.text = userDetail.userRealName
        binding.tvUserGitName.text = userDetail.userGitName
        binding.tvUserBio.text = userDetail.userBio
        binding.tvUserLocation.text = userDetail.userLocation
        binding.tvUserLink.text = userDetail.userBlogSite
        context?.also { Glide.with(it).load(userDetail.userImageUrl).into(binding.imageUser) }
        binding.cardViewStaff.isVisible = userDetail.isUserSiteAdmin()

        updateUserDetailsVisibility(isVisible = true)
        updateLoadingVisibility(isVisible = false)
        updateErrorMessageVisibility(isVisible = false)
        updateBtnRetryVisibility(isVisible = false)
    }

    override fun onGetUserDetailFailed() {
        updateUserDetailsVisibility(isVisible = false)
        updateLoadingVisibility(isVisible = false)
        updateErrorMessageVisibility(isVisible = true)
        updateBtnRetryVisibility(isVisible = true)
    }

    // endregion

    // region - View Visibility

    private fun updateUserDetailsVisibility(isVisible: Boolean) {
        binding.clUserDetails.isVisible = isVisible
    }

    private fun updateLoadingVisibility(isVisible: Boolean) {
        binding.progressBar.isVisible = isVisible
    }

    private fun updateErrorMessageVisibility(isVisible: Boolean) {
        binding.tvErrorMessage.isVisible = isVisible
    }

    private fun updateBtnRetryVisibility(isVisible: Boolean) {
        binding.btnRetry.isVisible = isVisible
    }

    // endregion
}