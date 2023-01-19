package com.thiagoperea.jafta.transaction.ui.type

import androidx.compose.ui.graphics.Color
import com.thiagoperea.jafta.design_system.theme.Green100
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.transaction.R

enum class TransactionScreenType(
    val titleRes: Int,
    val backgroundColor: Color
) {
    EXPENSE(
        titleRes = R.string.new_expense,
        backgroundColor = Red100
    ),
    INCOME(
        titleRes = R.string.new_income,
        backgroundColor = Green100
    )
}