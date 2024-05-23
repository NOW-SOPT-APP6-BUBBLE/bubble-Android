package com.sopt.bubble.feature.precise_store

import com.sopt.bubble.feature.precise_store.model.Ticket

data class PreciseStoreState(
    val isCheckedList: List<Boolean> = listOf(false, false, false),
    val isMore: Boolean = false,
    val isPurchasable: Boolean = false,

    val artistName: String = "",
    val bubbleDescription:String = "선물처럼 찾아오는 최애의 메시지와 함께하는 설레이는 일상!\n" +
            "최애 아티스트와 나만의 특별한 프라이빗 메시지, bubble for JYPnation",
    val artistLineup: String = "",
    val artistComingSoon: String? = null,

    val bubbleIntroduction: String = "bubble for JYPnation DAY6는 DAY6 팬들을 위한 특별한 서비스입니다.\n" +
"\n" +
"나만의 최애 DAY6 멤버가 직접 작성하는 개성 넘치는 프라이빗한 메시지를 받을 수 있습니다.\n" +
"\n" +
"bubble for JYPnation은 아티스트의 창작활동을 지원하고 응원합니다.",
    val ticketList: List<Ticket> = listOf()
)