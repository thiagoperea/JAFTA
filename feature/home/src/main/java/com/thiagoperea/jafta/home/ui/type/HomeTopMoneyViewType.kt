package com.thiagoperea.jafta.home.ui.type

import androidx.compose.ui.graphics.Color
import com.thiagoperea.jafta.design_system.theme.Green100
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.home.R

enum class HomeTopMoneyViewType(val iconRes: Int, val titleRes: Int, val color: Color) {
    INCOME(R.drawable.ic_income, R.string.income, Green100),
    EXPENSE(R.drawable.ic_expense, R.string.expense, Red100)
}