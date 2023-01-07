package com.thiagoperea.jafta.design_system

import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomButton(

) {
    Button(
        onClick = { /*TODO*/ },
        content = {
            Text("TESTE")
        }
    )
}

@Preview
@Composable
fun PreviewCustomButton() {
    MaterialTheme {
        Surface {
            CustomButton()
        }
    }
}