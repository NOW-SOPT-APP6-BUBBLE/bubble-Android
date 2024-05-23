package com.sopt.bubble.module

import com.sopt.bubble.data.service.PreciseStoreService

object ServicePool {
    val preciseStoreService = ApiFactory.create<PreciseStoreService>()
}