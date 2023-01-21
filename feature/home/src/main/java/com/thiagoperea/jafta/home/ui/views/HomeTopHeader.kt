package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.*
import com.thiagoperea.jafta.home.R

@Composable
fun HomeTopHeader() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_person),
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(
                    width = 1.dp,
                    color = Violet100,
                    shape = CircleShape
                )
        )

        Spacer(Modifier.weight(1f))

        OutlinedButton(
            onClick = {},
            contentPadding = PaddingValues(start = 8.dp, end = 12.dp),
            shape = RoundedCornerShape(32.dp),
            border = BorderStroke(1.dp, Violet20),
            colors = ButtonDefaults.outlinedButtonColors(
                backgroundColor = Color.Transparent
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(com.thiagoperea.jafta.design_system.R.drawable.ic_arrow_down),
                    contentDescription = null,
                    tint = Violet100,
                    modifier = Modifier
                        .size(24.dp)
                        .padding(4.dp)
                )

                Text(
                    text = "Outubro",
                    style = TextStyles.body3,
                    color = Dark50
                )
            }
        }

        Spacer(Modifier.weight(1f))

        IconButton(
            onClick = {},
            modifier = Modifier.size(32.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_notification),
                contentDescription = null,
                tint = Violet100
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeTopHeader() {
    JAFTATheme {
        HomeTopHeader()
    }
}