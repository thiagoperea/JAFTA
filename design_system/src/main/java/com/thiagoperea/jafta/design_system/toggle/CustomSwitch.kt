package com.thiagoperea.jafta.design_system.toggle

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.Light80
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20

@Composable
fun CustomSwitch(
    modifier: Modifier,
    title: String,
    subtitle: String,
    isChecked: Boolean,
    onCheckedChanged: (Boolean) -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(top = 8.dp, bottom = 8.dp)
        ) {
            Text(
                text = title,
                style = TextStyles.body1,
                color = Dark25
            )

            Spacer(Modifier.height(4.dp))

            Text(
                text = subtitle,
                style = TextStyles.medium13,
                color = Light20
            )
        }

        Switch(
            checked = isChecked,
            onCheckedChange = { onCheckedChanged(it) },
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
}