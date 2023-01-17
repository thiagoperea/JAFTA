package com.thiagoperea.jafta.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.Red100
import com.thiagoperea.jafta.design_system.theme.Red20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20
import com.thiagoperea.jafta.design_system.theme.Yellow100
import com.thiagoperea.jafta.design_system.theme.Yellow20
import com.thiagoperea.jafta.home.R
import com.thiagoperea.jafta.home.ui.views.HomeSpend
import com.thiagoperea.jafta.home.ui.views.HomeTop

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {

        item {
            HomeTop()
        }

        item {
            HomeSpend()
        }

        HomeTransactions()
    }
}

/*****/
/*****/
/*****/

data class TransactionData(
    val type: TransactionType,
    val description: String,
    val value: Double,
    val date: String
)

enum class TransactionType(
    val iconRes: Int,
    val iconColor: Color,
    val iconBgColor: Color
) {
    SHOPPING(R.drawable.ic_shopping_bag, Yellow100, Yellow20),
    SUBSCRIPTION(R.drawable.ic_subscription, Violet100, Violet20),
    FOOD(R.drawable.ic_restaurant, Red100, Red20)
}

/*****/
/*****/
/*****/

fun LazyListScope.HomeTransactions() {

    val fakeData = listOf(
        TransactionData(
            type = TransactionType.SHOPPING,
            description = "Buy some grocery",
            value = 120.0,
            date = "12/01/2023"
        ),
        TransactionData(
            type = TransactionType.SUBSCRIPTION,
            description = "Disney+ Annual Subscription",
            value = 80.0,
            date = "10/01/2023"
        ),
        TransactionData(
            type = TransactionType.FOOD,
            description = "Ramen at Ifood",
            value = 32.0,
            date = "05/01/2023"
        ),
    )

    item {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Transações Recentes",
                style = TextStyles.title3,
                color = Dark100,
                modifier = Modifier.weight(1f)
            )

            // TODO: should go to design system?
            Button(
                onClick = {},
                shape = RoundedCornerShape(32.dp),
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Violet20,
                    contentColor = Violet100
                ),
                content = {
                    Text(
                        text = "Ver todos",
                        style = TextStyles.body3
                    )
                },
            )
        }
    }

    items(fakeData) { item ->

        Row(
            modifier = Modifier
                .height(IntrinsicSize.Min)
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .background(color = Light80, shape = RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(item.type.iconRes),
                contentDescription = null,
                tint = item.type.iconColor,
                modifier = Modifier
                    .background(color = item.type.iconBgColor, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
                    .size(30.dp)
            )

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(8.dp)
            ) {
                Text(
                    text = item.type.name,
                    style = TextStyles.body1,
                    color = Dark25
                )

                Text(
                    text = item.description,
                    style = TextStyles.semiBold13,
                    color = Light20
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 8.dp)
            ) {
                Text(
                    text = item.value.toString(), //TODO: FORMAT
                    style = TextStyles.semiBold16,
                    color = Red100
                )

                Text(
                    text = item.date, //TODO: FORMAT
                    style = TextStyles.semiBold13,
                    color = Light20
                )
            }
        }
    }

    item {
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    JAFTATheme {
        HomeScreen()
    }
}