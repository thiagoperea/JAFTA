package com.thiagoperea.jafta.login.ui.pin

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.login.R

@Composable
fun SetupPinScreen(
    onNavigationUp: () -> Unit
) {

    Column(
        modifier = Modifier
            .background(color = Violet100)
    ) {
        Text(
            text = stringResource(R.string.lets_setup_your_pin),
            modifier = Modifier
                .padding(top = 46.dp)
                .fillMaxWidth(),
            style = TextStyles.title3,
            color = Light80,
            textAlign = TextAlign.Center
        )

        Row(
            modifier = Modifier
                .padding(top = 340.dp)
                .fillMaxWidth()
        )
        {
            Text(
                text = ONE,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = TWO,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = THREE,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = FOUR,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = FIVE,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = SIX,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = SEVEN,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = EIGHT,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Text(
                text = NINE,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Light80,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .width(64.dp)
                    .height(64.dp)
                    .clickable { onNavigationUp() },
            )
            Text(
                text = ZERO,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .clickable { },
                textAlign = TextAlign.Center,
                style = TextStyles.medium48,
                color = Light80
            )
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null,
                tint = Light80,
                modifier = Modifier
                    .padding(start = 47.dp, end = 47.dp, top = 16.dp, bottom = 16.dp)
                    .weight(1f)
                    .width(64.dp)
                    .height(64.dp)
                    .clickable { },
            )
        }
    }
}

@Preview
@Composable
fun SetupPinScreenPreview() {
    JAFTATheme {
        SetupPinScreen(onNavigationUp = {})
    }
}