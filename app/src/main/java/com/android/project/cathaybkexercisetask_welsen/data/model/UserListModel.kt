package com.android.project.cathaybkexercisetask_welsen.data.model

import com.google.gson.annotations.SerializedName

data class UserListModel(
    @SerializedName("id") val userId: Long,
    @SerializedName("login") val userName: String?,
    @SerializedName("avatar_url") val userImageUrl: String?,
    @SerializedName("site_admin") val userSiteAdmin: Boolean?
) {
    fun isUserSiteAdmin(): Boolean = userSiteAdmin == true
}

data class Response(
    val dataList: List<UserListModel>
)