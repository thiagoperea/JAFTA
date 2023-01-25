package com.thiagoperea.jafta.design_system.input

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Light60
import com.thiagoperea.jafta.design_system.theme.TextStyles

@Composable
fun CustomTextField(
    modifier: Modifier,
    label: String,
    value: String,
    onValueChanged: (String) -> Unit
) {

    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = { onValueChanged(it) },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Light60,
            unfocusedBorderColor = Light60,
            textColor = Dark100
        ),
        label = {
            Text(
                text = label,
                style = TextStyles.title2
            )
        }
    )
}