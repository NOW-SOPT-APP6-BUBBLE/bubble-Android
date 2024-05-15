package com.sopt.bubble.presentation.precise_store.model

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
