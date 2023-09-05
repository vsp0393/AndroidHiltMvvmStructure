package com.vsple.hiltapp.repository

import android.content.Context
import android.widget.Toast
import com.vsple.hiltapp.datamodel.prayermodel.PryerModel
import com.vsple.hiltapp.datamodel.prayermodel.chattymodel.ChattyModel
import com.vsple.hiltapp.datamodel.prayermodel.chattymodel.HomepageChatiesCollection
import com.vsple.hiltapp.network.ApiService
import com.vsple.hiltapp.network.Resources
import javax.inject.Inject


class AppRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPosts(): Resources<ChattyModel> {
        return try {
            val response = apiService.getPosts()
            if (response.isSuccessful) {
                Resources.Success(response.body()!!)
            } else {
                Resources.Error(response.code(), response.message())


            }
        } catch (e: Exception) {
            Resources.Error(0, e.message ?: "An error occurred")
        }
    }
}