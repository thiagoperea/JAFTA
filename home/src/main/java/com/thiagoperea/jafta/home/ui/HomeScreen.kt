package com.thiagoperea.jafta.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark75
import com.thiagoperea.jafta.design_system.theme.Green100
import com.thiagoperea.jafta.design_system.theme.HomeBackground
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.home.R
import com.thiagoperea.jafta.home.ui.views.HomeTopHeader

@Composable
fun HomeScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp))
            .background(HomeBackground)
    ) {
        // TOP BAR
        HomeTopHeader()

        Text(
            text = "Saldo da Conta",
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
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(16.dp))

            HomeTopMoneyView(
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun HomeTopMoneyView(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(Green100, RoundedCornerShape(32.dp))
            .padding(16.dp)
    ) {

        Icon(
            painter = painterResource(R.drawable.ic_income),
            contentDescription = null,
            tint = Green100
        )

        Column {

            Text(
                text = "Receitas",
                style = TextStyles.body3,
                color = HomeBackground
            )

            Text(
                text = "R$ 5.000",
                style = TextStyles.semiBold22,
                color = HomeBackground
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    JAFTATheme {
        HomeScreen()
    }
}