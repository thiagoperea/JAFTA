package com.thiagoperea.jafta.design_system.input

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.thiagoperea.jafta.design_system.R
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Light60
import com.thiagoperea.jafta.design_system.theme.TextStyles


@Composable
fun CustomDropdown(
    modifier: Modifier = Modifier,
    label: String,
    value: TextFieldValue,
    onValueChanged: (TextFieldValue) -> Unit,
    dropdownDataset: List<String>
) {

    val dropdownExpandState = remember { mutableStateOf(false) }
    val dropdownPossibilites = remember { mutableListOf(*dropdownDataset.toTypedArray()) }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.BottomStart
    ) {

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = { newValue ->
                onValueChanged(newValue)

                dropdownPossibilites.clear()

                dropdownPossibilites.addAll(
                    dropdownDataset.filter {
                        it != newValue.text && it.startsWith(
                            newValue.text,
                            ignoreCase = true
                        )
                    }
                )

                dropdownExpandState.value = dropdownPossibilites.isNotEmpty()
            },
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
            },
            trailingIcon = {
                IconButton(
                    onClick = {
                        dropdownPossibilites.clear()
                        dropdownPossibilites.addAll(dropdownDataset)

                        dropdownExpandState.value = !dropdownExpandState.value
                    }
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_arrow_down),
                        contentDescription = null,
                    )
                }
            },
        )

        DropdownMenu(
            expanded = dropdownExpandState.value,
            properties = PopupProperties(
                focusable = false,
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            ),
            onDismissRequest = {
                dropdownExpandState.value = false
            }
        ) {
            dropdownPossibilites.forEach { item ->

                DropdownMenuItem(
                    onClick = {
                        onValueChanged(
                            TextFieldValue(
                                text = item,
                                selection = TextRange(item.length)
                            )
                        )

                        dropdownExpandState.value = false
                    }
                ) {
                    Text(item)
                }
            }
        }
    }
}