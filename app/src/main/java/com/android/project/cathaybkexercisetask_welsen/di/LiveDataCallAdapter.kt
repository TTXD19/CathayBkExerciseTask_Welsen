package com.android.project.cathaybkexercisetask_welsen.di

import androidx.lifecycle.LiveData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type

class LiveDataCallAdapter<T>(private val responseType: Type) : CallAdapter<T, LiveData<T>> {
    override fun responseType(): Type {
        return responseType
    }

    override fun adapt(call: Call<T>): LiveData<T> {
        return object : LiveData<T>() {
            override fun onActive() {
                super.onActive()
                call.enqueue(object : Callback<T> {
                    override fun onResponse(call: Call<T>, response: Response<T>) {
                        postValue(response.body())
                    }

                    override fun onFailure(call: Call<T>, t: Throwable) {

                    }
                })
            }
        }
    }
}