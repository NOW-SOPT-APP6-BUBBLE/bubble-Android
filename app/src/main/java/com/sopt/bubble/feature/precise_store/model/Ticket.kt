package com.sopt.bubble.feature.precise_store.model

data class Ticket(
    val number: String,
    val originalPrice: String?,
    val price: String
)

val mockTicketList = listOf<Ticket>(
    Ticket(
        number = "1",
        originalPrice = null,
        price = "4,500"
    ),
    Ticket(
        number = "2",
        originalPrice = "9,000",
        price = "8,000"
    )
)

val mockTicketList1 = listOf<Ticket>(
    Ticket(
        number = "1",
        originalPrice = null,
        price = "4,500"
    ),
    Ticket(
        number = "2",
        originalPrice = "9,000",
        price = "8,000"
    ),
    Ticket(
        number = "3",
        originalPrice = "13,500",
        price = "12,500"
    ),
    Ticket(
        number = "4",
        originalPrice = "18,000",
        price = "16,500"
    ),
    Ticket(
        number = "5",
        originalPrice = "22,500",
        price = "21,000"
    ),
    Ticket(
        number = "6",
        originalPrice = "27,000",
        price = "25,000"
    )
)
