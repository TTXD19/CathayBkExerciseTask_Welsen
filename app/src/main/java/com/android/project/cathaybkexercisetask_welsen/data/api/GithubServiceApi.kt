package com.android.project.cathaybkexercisetask_welsen.data.api

import androidx.lifecycle.LiveData
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubServiceApi {

    @GET("users")
    fun getUserList(
        @Query("since") startFrom: Int,
        @Query("per_page") perPage: Int
    ): LiveData<List<UserListModel>>
}