package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Violet100
import kotlin.random.Random

@Composable
fun HomeSpendGraph() {

    val graphHeight = 200.dp

    val fakeData = List(15) {
        Random(it).nextInt(0, 300)
    }

    val maxValue = fakeData.max()

    Canvas(
        modifier = Modifier
            .height(graphHeight)
            .fillMaxWidth(),
        onDraw = {
            val boxSize = size
            val pointWidth = boxSize.width / fakeData.size
            val strokeWidth = 2 * density
            val markerWidth = 4 * density

            val safeMaxY = boxSize.height - markerWidth
            val safeMinY = markerWidth

            var lastX = 0f
            var lastY = boxSize.height

            fakeData.forEach { data ->

                val startX = lastX
                val endX = startX + pointWidth

                val yPercent = data / maxValue.toFloat()
                var startY = lastY
                var endY = boxSize.height - (boxSize.height * yPercent)

                if (startY > safeMaxY) {
                    startY = safeMaxY
                } else if (startY < safeMinY) {
                    startY = safeMinY
                }

                if (endY > safeMaxY) {
                    endY = safeMaxY
                } else if (endY < safeMinY) {
                    endY = safeMinY
                }

                drawLine(
                    color = Violet100,
                    start = Offset(startX, startY),
                    end = Offset(endX, endY),
                    cap = StrokeCap.Round,
                    strokeWidth = strokeWidth
                )

                drawCircle(
                    color = Violet100,
                    radius = markerWidth,
                    center = Offset(endX, endY)
                )

                lastX = endX
                lastY = endY
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeSpendGraph() {
    JAFTATheme {
        HomeSpendGraph()
    }
}