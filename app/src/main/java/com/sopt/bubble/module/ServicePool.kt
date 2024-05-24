package com.sopt.bubble.module


import com.sopt.bubble.data.service.FriendDetailService
import com.sopt.bubble.data.service.FriendsService
import com.sopt.bubble.data.service.PreciseStoreService
import com.sopt.bubble.data.service.StoreService

object ServicePool {
    val friendService = ApiFactory.create<FriendsService>()
    val friendDetailService = ApiFactory.create<FriendDetailService>()
    val storeService = ApiFactory.create<StoreService>()
    val preciseStoreService = ApiFactory.create<PreciseStoreService>()
}