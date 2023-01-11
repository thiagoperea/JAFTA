package com.thiagoperea.jafta.home.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import com.thiagoperea.jafta.home.ui.views.HomeSpendGraph
import com.thiagoperea.jafta.home.ui.views.HomeTop

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {

        HomeTop()

        // GRAPHICS COMPONENT
        Text(
            text = "Frequência de gastos",
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
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        ) {

            frequencyListState.forEachIndexed { index, frequencyItem ->

                val backgroundColor: Color
                val contentColor: Color
                val border: BorderStroke?
                val textStyle: TextStyle

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

                if (index < frequencyListState.size - 1) {
                    Spacer(Modifier.width(16.dp))
                }
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