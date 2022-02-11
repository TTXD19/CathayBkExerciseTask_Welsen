package com.android.project.cathaybkexercisetask_welsen.di

import retrofit2.Retrofit

class NetworkManger(private val retrofit: Retrofit) {

    fun getRetrofit(): Retrofit = retrofit

    inline fun <reified T> getApiServices(serviceClass: Class<T>): T {
        return getRetrofit().create(serviceClass)
    }
}