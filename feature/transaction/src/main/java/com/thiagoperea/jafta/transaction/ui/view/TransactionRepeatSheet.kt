package com.thiagoperea.jafta.transaction.ui.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.CustomSelectableInput
import com.thiagoperea.jafta.design_system.button.CustomButton
import com.thiagoperea.jafta.design_system.button.CustomButtonType
import com.thiagoperea.jafta.design_system.input.CustomDropdown
import com.thiagoperea.jafta.design_system.theme.Violet40
import com.thiagoperea.jafta.transaction.R

@Composable
fun TransactionRepeatSheet(
    onNextClick: () -> Unit
) {
    val frequencyState = remember { mutableStateOf(TextFieldValue()) }
    val frequencyList = listOf(
        stringResource(R.string.dialy),
        stringResource(R.string.weekly),
        stringResource(R.string.monthly),
        stringResource(R.string.yearly),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .padding(top = 8.dp)
                .width(36.dp)
                .height(4.dp)
                .background(color = Violet40, shape = RoundedCornerShape(8.dp))
        )

        CustomDropdown(
            label = stringResource(R.string.frequency),
            value = frequencyState.value,
            onValueChanged = { frequencyState.value = it },
            dropdownDataset = frequencyList,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 24.dp, end = 16.dp)
        )

        /* TODO: THIS IS AN SELECTABLE INPUT FIELD */
        CustomSelectableInput(
            text = stringResource(R.string.end_date),
            onClick = {
                Log.d("JAFTA", "CLICKED, CHANGE TEXT")
            },
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp),
        )

        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            type = CustomButtonType.PRIMARY,
            text = stringResource(R.string.next),
            onClick = onNextClick
        )
    }
}