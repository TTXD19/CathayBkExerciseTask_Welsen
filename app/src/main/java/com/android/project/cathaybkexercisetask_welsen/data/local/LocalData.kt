package com.android.project.cathaybkexercisetask_welsen.data.local

import android.content.Context
import com.android.project.cathaybkexercisetask_welsen.data.model.Response
import com.android.project.cathaybkexercisetask_welsen.data.model.UserListModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.reflect.Type

class LocalData {
    fun getDataFromAssets(context: Context, fileName: String): Response? {
        val jsonString: String = context.assets.open(fileName).bufferedReader().use { it.readText() }
        return Gson().fromJson(jsonString, Response::class.java)
    }

    fun getDataFromAssetsTest(context: Context, fileName: String): List<UserListModel> {
        val inputStream: InputStream = context.assets.open(fileName)
        val reader = InputStreamReader(inputStream)
        val type: Type = object : TypeToken<List<UserListModel>>() {}.type
        return Gson().fromJson(reader, type)
    }
}