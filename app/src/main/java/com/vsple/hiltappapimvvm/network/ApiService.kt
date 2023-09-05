package com.vsple.hiltapp.network

import com.vsple.hiltapp.datamodel.prayermodel.PryerModel
import com.vsple.hiltapp.datamodel.prayermodel.chattymodel.ChattyModel
import com.vsple.hiltapp.datamodel.prayermodel.chattymodel.HomepageChatiesCollection
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("config/")
    suspend fun getPosts(): Response<ChattyModel>
}
