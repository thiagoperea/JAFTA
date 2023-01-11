package com.thiagoperea.jafta.home.ui.views

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Violet100
import kotlin.random.Random

@Composable
fun HomeSpendGraph() {

    val graphHeight = 200.dp

    val fakeData = List(20) {
        Random(it).nextInt(0, 300)
    }

    val maxValue = fakeData.max()

    Canvas(
        modifier = Modifier
            .height(graphHeight)
            .fillMaxWidth(),
        onDraw = {
//            drawGrid(
//                columnCount = 20,
//                rowCount = 10
//            )

            val width = size.width
            val height = size.height

            val lineExample = Path().apply {
                moveTo(x = 16 * density, y = height - (16 * density))
                lineTo(x = 32 * density, y = height - (32 * density))
                close()
            }

            drawPath(
                path = lineExample,
                color = Violet100,
                style = Stroke(width = 2f)
            )
        }
    )
}

fun DrawScope.drawGrid(columnCount: Int, rowCount: Int) {
    val width = size.width
    val height = size.height

    val columnSize = width / columnCount
    val rowSize = height / rowCount

    var columnDrawPosition = 0f
    repeat(columnCount) {
        drawLine(
            color = Color.Black,
            start = Offset(x = columnDrawPosition, y = 0f),
            end = Offset(x = columnDrawPosition, y = height)
        )

        columnDrawPosition += columnSize
    }

    var rowDrawPosition = 0f
    repeat(rowCount) {
        drawLine(
            color = Color.Black,
            start = Offset(x = 0f, y = rowDrawPosition),
            end = Offset(x = width, y = rowDrawPosition)
        )

        rowDrawPosition += rowSize
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeSpendGraph() {
    JAFTATheme {
        HomeSpendGraph()
    }
}