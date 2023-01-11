package com.thiagoperea.jafta.home.ui.views.graphs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.home.ui.model.HomeSpendGraphModel
import kotlin.math.abs
import kotlin.random.Random


@Composable
fun HomeLineGraph() {

    val graphHeight = 200.dp

    val fakeData = List(20) {
        Random(it).nextInt(0, 300)
    }

    val fakeDataMapped = List(fakeData.size) { index ->

        val previous = fakeData.getOrNull(index - 1)
        val current = fakeData[index]

        val middlePoint = if (previous == null) {
            current / 2
        } else {
            abs(current - previous)
        }

        HomeSpendGraphModel(
            start = previous ?: 0,
            middle = middlePoint,
            end = current
        )
    }

    val maxValue = fakeData.max()

    LazyRow(
        modifier = Modifier
            .height(graphHeight)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
    ) {

        items(fakeDataMapped) { point ->

            Box(
                modifier = Modifier
                    .width(64.dp)
                    .height(graphHeight)
                    .drawBehind {

                        val boxSize = size
                        val startHeightPercent = point.start / maxValue.toFloat()
                        val endHeightPercent = point.end / maxValue.toFloat()

                        val startX = 0f
                        val endX = boxSize.width
                        val startY = boxSize.height - (boxSize.height * startHeightPercent)
                        val endY = boxSize.height - (boxSize.height * endHeightPercent)

                        drawLine(
                            color = Violet100,
                            strokeWidth = 2 * density,
                            start = Offset(x = startX, y = startY),
                            end = Offset(x = endX, y = endY)
                        )

                        drawCircle(
                            color = Violet100,
                            center = Offset(x = endX, y = endY),
                            radius = 4 * density
                        )
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeLineGraph() {
    JAFTATheme {
        HomeLineGraph()
    }
}