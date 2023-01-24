package com.thiagoperea.jafta.transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.ArrowTopAppBar
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.input.CustomDropdown
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.Light60
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20
import com.thiagoperea.jafta.transaction.R
import com.thiagoperea.jafta.transaction.ui.type.TransactionScreenType

@Composable
fun TransactionScreenContent(
    type: TransactionScreenType,
    onNavigateUp: () -> Unit,
    isRepeatingTransaction: Boolean,
    onRepeatingTransactionChanged: (Boolean) -> Unit
) {
    val scrollState = rememberScrollState()
    val valueState = remember { mutableStateOf("") }

    val categoryState = remember { mutableStateOf(TextFieldValue()) }
    val descriptionState = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(type.backgroundColor)
            .verticalScroll(scrollState)
    ) {
        ArrowTopAppBar(
            text = stringResource(type.titleRes),
            onNavigateUp = { onNavigateUp() },
            backgroundColor = type.backgroundColor,
            contentColor = Color.White
        )

        Text(
            text = stringResource(R.string.how_much),
            style = TextStyles.semiBold16,
            color = Light80.copy(alpha = 0.64f),
            modifier = Modifier.padding(start = 24.dp, top = 64.dp)
        )

        BasicTextField(
            value = valueState.value,
            onValueChange = {
                if (it.length <= 9) {
                    valueState.value = it
                }
            },
            textStyle = TextStyles.semiBold48.copy(color = Color.White),
            cursorBrush = SolidColor(Color.White),
            maxLines = 1,
            modifier = Modifier.padding(start = 24.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            visualTransformation = MoneyMask()
        )

        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .weight(1f)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
        ) {

            CustomDropdown(
                modifier = Modifier.padding(top = 24.dp, start = 16.dp, end = 16.dp),
                label = stringResource(R.string.category),
                value = categoryState.value,
                onValueChanged = { categoryState.value = it },
                dropdownDataset = listOf("Contas", "Restaurante", "Necessidades")
                //TODO: receive from viewmodel
            )

            //TODO: create design system \/
            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                value = descriptionState.value,
                onValueChange = { descriptionState.value = it },
                shape = RoundedCornerShape(16.dp),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Light60,
                    unfocusedBorderColor = Light60,
                    textColor = Dark100
                ),
                label = {
                    Text(
                        text = stringResource(R.string.description),
                        style = TextStyles.title2
                    )
                }
            )

            //TODO: create design system \/
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, top = 16.dp, end = 16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                ) {
                    Text(
                        text = stringResource(R.string.repeat),
                        style = TextStyles.body1,
                        color = Dark25
                    )

                    Spacer(Modifier.height(4.dp))

                    Text(
                        text = stringResource(R.string.repeat_transaction),
                        style = TextStyles.medium13,
                        color = Light20
                    )
                }

                Switch(
                    checked = isRepeatingTransaction,
                    onCheckedChange = { onRepeatingTransactionChanged(it) },
                    colors = SwitchDefaults.colors(
                        uncheckedTrackColor = Violet20,
                        uncheckedThumbColor = Light80,
                        uncheckedTrackAlpha = 1f,
                        checkedTrackColor = Violet100,
                        checkedThumbColor = Light80,
                        checkedTrackAlpha = 1f,
                    )
                )
            }

            // SPACER AND BUTTON
            Spacer(Modifier.weight(1f))

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                type = CustomButtonType.PRIMARY,
                text = stringResource(R.string.save),
                onClick = {

                }
            )
        }
    }
}

@Preview
@Composable
fun PreviewTransactionScreenContent() {
    JAFTATheme {
        TransactionScreenContent(
            type = TransactionScreenType.EXPENSE,
            onNavigateUp = {},
            isRepeatingTransaction = false,
            onRepeatingTransactionChanged = {}
        )
    }
}