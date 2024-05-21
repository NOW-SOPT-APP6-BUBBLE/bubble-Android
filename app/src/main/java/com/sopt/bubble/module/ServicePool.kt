package com.sopt.bubble.module

import com.sopt.bubble.data.service.StoreService

object ServicePool {

    val storeService = ApiFactory.create<StoreService>()
}