package com.thiagoperea.jafta.home.ui.type

import androidx.compose.ui.graphics.Color
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.design_system.theme.Red20
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20
import com.thiagoperea.jafta.design_system.theme.Yellow100
import com.thiagoperea.jafta.design_system.theme.Yellow20
import com.thiagoperea.jafta.home.R

enum class TransactionType(
    val iconRes: Int,
    val iconColor: Color,
    val iconBgColor: Color
) {
    SHOPPING(R.drawable.ic_shopping_bag, Yellow100, Yellow20),
    SUBSCRIPTION(R.drawable.ic_subscription, Violet100, Violet20),
    FOOD(R.drawable.ic_restaurant, Red100, Red20)
}