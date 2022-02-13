package com.android.project.cathaybkexercisetask_welsen.data.repository

sealed class DataResult<T> {
    data class Success<T>(val data: T) : DataResult<T>()
    data class Failure<T>(val retrieve: String = "Network Failure") : DataResult<T>()
}