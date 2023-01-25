package com.thiagoperea.jafta.design_system.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20

@Composable
fun CustomPill(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit
) {

    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(32.dp),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Violet20,
            contentColor = Violet100
        ),
        content = {
            Text(
                text = text,
                style = TextStyles.body3
            )
        },
    )
}