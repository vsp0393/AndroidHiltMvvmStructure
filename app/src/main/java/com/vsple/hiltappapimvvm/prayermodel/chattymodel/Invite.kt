package com.vsple.hiltapp.datamodel.prayermodel.chattymodel

data class Invite(
    val is_active: Boolean,
    val limit: Int,
    val messages: List<Int>
)