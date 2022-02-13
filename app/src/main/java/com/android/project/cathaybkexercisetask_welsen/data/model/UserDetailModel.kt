package com.android.project.cathaybkexercisetask_welsen.data.model

import com.google.gson.annotations.SerializedName

data class UserDetailModel(
    @SerializedName("avatar_url") val userImageUrl: String?,
    @SerializedName("name") val userRealName: String?,
    @SerializedName("login") val userGitName: String?,
    @SerializedName("bio") val userBio: String?,
    @SerializedName("site_admin") val userSiteAdmin: Boolean?,
    @SerializedName("location") val userLocation: String?,
    @SerializedName("blog") val userBlogSite: String?
){
    fun isUserSiteAdmin(): Boolean = userSiteAdmin == true
}