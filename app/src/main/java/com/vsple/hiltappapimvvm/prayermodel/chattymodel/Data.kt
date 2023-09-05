package com.vsple.hiltapp.datamodel.prayermodel.chattymodel

data class Data(
    val aos_config: AosConfig,
    val app_config: AppConfig,
    val homepageChatiesCollection: List<HomepageChatiesCollection>,
    val ios_config: IosConfig,
    val labels: List<Label>,
    val links: Links,
    val onboarding: List<Onboarding>,
    val rewards: Rewards,
    val subscriptions: Subscriptions,
    val worker: String
)