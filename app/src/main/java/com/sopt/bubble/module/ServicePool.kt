package com.sopt.bubble.module

import com.sopt.bubble.data.service.FriendDetailService

object ServicePool {

    val friendDetailService = ApiFactory.create<FriendDetailService>()
}