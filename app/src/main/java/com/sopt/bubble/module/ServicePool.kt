package com.sopt.bubble.module

import com.sopt.bubble.data.service.FriendsService

import com.sopt.bubble.data.service.FriendDetailService

import com.sopt.bubble.data.service.StoreService

import com.sopt.bubble.data.service.PreciseStoreService

object ServicePool {
    val friendService = ApiFactory.create<FriendsService>()

    val friendDetailService = ApiFactory.create<FriendDetailService>()
    val storeService = ApiFactory.create<StoreService>()
    val preciseStoreService = ApiFactory.create<PreciseStoreService>()
}