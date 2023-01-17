package com.thiagoperea.jafta.design_system

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.TextStyles


@Composable
fun ArrowTopAppBar(
    text: String,
    onNavigateUp: () -> Unit
) {
    TopAppBar(
        title = {
            Text(
                text = text,
                modifier = Modifier
                    .fillMaxWidth(),
                style = TextStyles.title3
            )
        },
        contentColor = Color.Black,
        backgroundColor = Color.White,
        navigationIcon = {
            IconButton(
                onClick = onNavigateUp
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null,
                )
            }
        },
        elevation = 0.dp
    )
}