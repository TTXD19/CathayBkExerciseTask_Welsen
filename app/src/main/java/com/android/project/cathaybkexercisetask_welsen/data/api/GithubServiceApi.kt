package com.android.project.cathaybkexercisetask_welsen.data.api

import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubServiceApi {

    @GET("users")
    fun getUserList(
        @Query("since") startFrom: Int,
        @Query("per_page") perPage: Int
    ): Single<List<UserListModel>>
}