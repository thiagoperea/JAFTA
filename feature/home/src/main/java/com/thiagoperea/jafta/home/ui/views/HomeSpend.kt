package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Chip
import androidx.compose.material.ChipDefaults
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet20
import com.thiagoperea.jafta.design_system.theme.Yellow100
import com.thiagoperea.jafta.design_system.theme.Yellow20
import com.thiagoperea.jafta.home.R
import com.thiagoperea.jafta.home.ui.model.FrequencyItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeSpend() {
    Column {

        Text(
            text = stringResource(R.string.spend_frequency),
            style = TextStyles.title3,
            color = Dark100,
            modifier = Modifier.padding(16.dp)
        )

        val frequencyListState = remember {
            mutableStateListOf(
                FrequencyItem(R.string.today, true),
                FrequencyItem(R.string.week, false),
                FrequencyItem(R.string.month, false),
                FrequencyItem(R.string.year, false)
            )
        }

        HomeSpendGraph()

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {

            var backgroundColor: Color
            var contentColor: Color
            var border: BorderStroke?
            var textStyle: TextStyle

            frequencyListState.forEach { frequencyItem ->

                if (frequencyItem.isEnabled) {
                    backgroundColor = Yellow20
                    contentColor = Yellow100
                    border = null
                    textStyle = TextStyles.bold14
                } else {
                    backgroundColor = Color.Transparent
                    contentColor = Light20
                    border = BorderStroke(1.dp, Violet20)
                    textStyle = TextStyles.body3
                }

                Chip(
                    onClick = {
                        //viewModel.onFrequencyClick(frequencyItem)
                    },
                    colors = ChipDefaults.chipColors(
                        backgroundColor = backgroundColor,
                        contentColor = contentColor
                    ),
                    border = border,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = stringResource(frequencyItem.frequency),
                        style = textStyle,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeSpend() {
    JAFTATheme {
        HomeSpend()
    }
}