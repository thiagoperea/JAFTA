package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Green100
import com.thiagoperea.jafta.design_system.theme.HomeBackground
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.home.R


enum class HomeTopMoneyViewType(val iconRes: Int, val titleRes: Int, val color: Color) {
    INCOME(R.drawable.ic_income, R.string.income, Green100),
    EXPENSE(R.drawable.ic_expense, R.string.expense, Red100)
}

@Composable
fun HomeTopMoneyView(
    modifier: Modifier = Modifier,
    type: HomeTopMoneyViewType
) {
    Row(
        modifier = modifier
            .height(IntrinsicSize.Min)
            .background(type.color, RoundedCornerShape(32.dp))
            .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 8.dp)
    ) {

        Icon(
            painter = painterResource(type.iconRes),
            contentDescription = null,
            tint = type.color,
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(HomeBackground)
                .padding(16.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {

            Text(
                text = stringResource(type.titleRes),
                style = TextStyles.body3,
                color = HomeBackground
            )

            Text(
                text = "R$ 555.000",
                style = TextStyles.bold16,
                color = HomeBackground
            )
        }
    }
}