package com.thiagoperea.jafta.transaction.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.ArrowTopAppBar
import com.thiagoperea.jafta.design_system.button.CustomButton
import com.thiagoperea.jafta.design_system.button.CustomButtonType
import com.thiagoperea.jafta.design_system.button.CustomPill
import com.thiagoperea.jafta.design_system.input.CustomDropdown
import com.thiagoperea.jafta.design_system.input.CustomTextField
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.toggle.CustomSwitch
import com.thiagoperea.jafta.transaction.R
import com.thiagoperea.jafta.transaction.ui.type.TransactionScreenType

@Composable
fun TransactionScreenContent(
    type: TransactionScreenType,
    onNavigateUp: () -> Unit,
    isRepeatingTransaction: Boolean,
    onRepeatingTransactionChanged: (Boolean) -> Unit,
    frequency: String?,
    endDate: String?,
    onEditFrequencyClick: () -> Unit,
    onSaveClick: () -> Unit,
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
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                label = stringResource(R.string.category),
                value = categoryState.value,
                onValueChanged = { categoryState.value = it },
                dropdownDataset = listOf("Contas", "Restaurante", "Necessidades")
                //TODO: receive from viewmodel
            )

            CustomTextField(
                modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp),
                label = stringResource(R.string.description),
                value = descriptionState.value,
                onValueChanged = { descriptionState.value = it }
            )

            CustomSwitch(
                modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
                title = stringResource(R.string.repeat),
                subtitle = stringResource(R.string.repeat_transaction),
                isChecked = isRepeatingTransaction,
                onCheckedChanged = onRepeatingTransactionChanged
            )

            if (frequency != null && endDate != null) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(R.string.frequency),
                            style = TextStyles.body3,
                            color = Dark25
                        )
                        Text(
                            text = frequency,
                            style = TextStyles.medium13,
                            color = Light20
                        )
                    }

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(
                            text = stringResource(R.string.end_date),
                            style = TextStyles.body3,
                            color = Dark25
                        )
                        Text(
                            text = endDate,
                            style = TextStyles.medium13,
                            color = Light20
                        )
                    }

                    CustomPill(
                        text = stringResource(R.string.edit),
                        onClick = onEditFrequencyClick
                    )
                }
            }

            // SPACER AND BUTTON
            Spacer(Modifier.weight(1f))

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                type = CustomButtonType.PRIMARY,
                text = stringResource(R.string.save),
                onClick = onSaveClick
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
            onRepeatingTransactionChanged = {},
            frequency = null,
            endDate = null,
            onEditFrequencyClick = {},
            onSaveClick = {}
        )
    }
}