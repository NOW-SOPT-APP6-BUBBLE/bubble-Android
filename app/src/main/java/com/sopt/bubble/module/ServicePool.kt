package com.sopt.bubble.module

import com.sopt.bubble.data.service.FriendsService

import com.sopt.bubble.data.service.StoreService

object ServicePool {
    val friendService = ApiFactory.create<FriendsService>()

    val storeService = ApiFactory.create<StoreService>()
}