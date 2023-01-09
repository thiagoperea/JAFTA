package com.thiagoperea.jafta.design_system

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20

enum class CustomButtonType {
    PRIMARY, SECONDARY
}

@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    type: CustomButtonType = CustomButtonType.PRIMARY,
    text: String,
    onClick: () -> Unit
) {


    //TODO: change to enum values
    val buttonColors = if (type == CustomButtonType.PRIMARY) {
        ButtonDefaults.buttonColors(
            backgroundColor = Violet100,
            contentColor = Light80
        )
    } else {
        ButtonDefaults.buttonColors(
            backgroundColor = Violet20,
            contentColor = Violet100
        )
    }

    Button(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        onClick = onClick,
        content = {
            Text(
                modifier = Modifier.padding(vertical = 4.dp),
                text = text,
                style = TextStyles.title3
            )
        },
        colors = buttonColors,
        shape = RoundedCornerShape(16.dp),
        elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
    )
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCustomButton() {
    MaterialTheme {
        Column {

            CustomButton(
                text = "Teste",
                type = CustomButtonType.PRIMARY,
                onClick = {}
            )

            CustomButton(
                text = "Teste",
                type = CustomButtonType.SECONDARY,
                onClick = {}
            )
        }
    }
}