package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark75
import com.thiagoperea.jafta.design_system.theme.HomeBackground
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.home.R
import com.thiagoperea.jafta.home.ui.type.HomeTopMoneyViewType

@Composable
fun HomeTop() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .background(HomeBackground)
    ) {

        HomeTopHeader()

        Text(
            text = stringResource(R.string.account_balance),
            style = TextStyles.body3,
            color = Light20
        )

        Text(
            text = "R$ 9.400",
            style = TextStyles.semiBold40,
            color = Dark75,
        )

        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp)
        ) {
            HomeTopMoneyView(
                modifier = Modifier.weight(1f),
                type = HomeTopMoneyViewType.INCOME
            )

            Spacer(Modifier.width(16.dp))

            HomeTopMoneyView(
                modifier = Modifier.weight(1f),
                type = HomeTopMoneyViewType.EXPENSE
            )
        }
    }
}