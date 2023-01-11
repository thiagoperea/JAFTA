package com.thiagoperea.jafta.home.ui.views.graphs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Violet100
import kotlin.random.Random


@Composable
fun HomeBarGraph() {

    val graphHeight = 200.dp

    val fakeData = List(20) {
        Random(it).nextInt(0, 300)
    }

    val maxValue = fakeData.max()

    LazyRow(
        modifier = Modifier
            .height(graphHeight)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(fakeData) { point ->

            val pointHeightPercent = point / maxValue.toFloat()
            val barHeight = graphHeight * pointHeightPercent

            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(barHeight)
                    .background(Violet100)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeBarGraph() {
    JAFTATheme {
        HomeBarGraph()
    }
}