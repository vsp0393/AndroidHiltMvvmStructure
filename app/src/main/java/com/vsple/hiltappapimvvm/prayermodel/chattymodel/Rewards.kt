package com.vsple.hiltapp.datamodel.prayermodel.chattymodel

data class Rewards(
    val default_messages_count: Int,
    val default_referral_count: Int,
    val messages_update_frequency: Int,
    val rewards: RewardsX,
    val rewards_status: String,
    val subscription_status: String
)