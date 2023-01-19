package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.HomeBackground
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.home.ui.type.HomeTopMoneyViewType

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
                .clip(RoundedCornerShape(8.dp))
                .background(HomeBackground)
                .padding(8.dp)
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
                text = "R$ 55.000",
                style = TextStyles.bold16,
                color = HomeBackground
            )
        }
    }
}

@Preview
@Composable
fun PreviewHomeTopMoneyView() {
    JAFTATheme {
        HomeTopMoneyView(type = HomeTopMoneyViewType.INCOME)
    }
}