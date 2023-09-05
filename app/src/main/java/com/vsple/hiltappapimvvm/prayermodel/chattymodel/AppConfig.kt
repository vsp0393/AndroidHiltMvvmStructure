package com.vsple.hiltapp.datamodel.prayermodel.chattymodel

data class AppConfig(
    val conversation_disclaimer: String,
    val feedback_after_number_of_conversation: Int,
    val forced_update: Int,
    val preferred_languages: List<PreferredLanguage>,
    val user_invite: UserInvite
)