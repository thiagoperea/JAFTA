package com.thiagoperea.jafta.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Chip
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.*
import com.thiagoperea.jafta.home.ui.views.HomeTop

@Composable
fun HomeScreen() {
    Column {

        HomeTop()

        // GRAPHICS COMPONENT
        Text(
            text = "Frequência de gastos",
            style = TextStyles.title3,
            color = Dark100,
            modifier = Modifier.padding(16.dp)
        )

        val minHeightGraph = 200.dp

        Box(
            modifier = Modifier
                .height(minHeightGraph)
                .fillMaxWidth()
                .background(Color.Magenta.copy(alpha = 0.3f))
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(32.dp),
                enabled = true,
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = Yellow20,
                    contentColor = Yellow100
                ),
                border = null
            ) {
                Text(
                    text = "Today",
                    style = TextStyles.bold14
                )
            }

            //TODO: DO IT USING CHIP AND A CHIPGROUP
            Chip(onClick = { /*TODO*/ }) {

            }

            OutlinedButton(
                onClick = {},
                shape = RoundedCornerShape(32.dp),
            ) {
                Text("Week")
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("Month")
            }

            OutlinedButton(
                onClick = {}
            ) {
                Text("Year")
            }
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