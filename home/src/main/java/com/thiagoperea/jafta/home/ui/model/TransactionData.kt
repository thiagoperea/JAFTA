package com.thiagoperea.jafta.home.ui.model

import com.thiagoperea.jafta.home.ui.type.TransactionType

data class TransactionData(
    val type: TransactionType,
    val description: String,
    val value: Double,
    val date: String
)