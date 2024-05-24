package com.sopt.bubble.module


import com.sopt.bubble.data.service.FriendDetailService

import com.sopt.bubble.data.service.StoreService

import com.sopt.bubble.data.service.PreciseStoreService
import com.sopt.bubble.data.service.FriendsDetailService
import com.sopt.bubble.data.service.FriendsService

object ServicePool {
    val friendDetailService = ApiFactory.create<FriendDetailService>()
    val storeService = ApiFactory.create<StoreService>()
    val preciseStoreService = ApiFactory.create<PreciseStoreService>()
}