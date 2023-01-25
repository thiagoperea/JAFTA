package com.thiagoperea.jafta.design_system

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.Light60
import com.thiagoperea.jafta.design_system.theme.TextStyles

@Composable
fun CustomSelectableInput(
    modifier: Modifier,
    text: String,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .border(1.dp, Light60, RoundedCornerShape(16.dp))
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = TextStyles.title2,
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 20.dp)
                .weight(1f)
        )

        Icon(
            painter = painterResource(R.drawable.ic_arrow_down),
            tint = Light20,
            contentDescription = null,
            modifier = Modifier.padding(end = 16.dp)
        )
    }
}