package com.thiagoperea.jafta.login.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sing - Up",
                        modifier = Modifier
                            .fillMaxWidth(),
                        style = TextStyles.title3
                    )
                },
                contentColor = Color.Black,
                backgroundColor = Color.White,
                navigationIcon = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
//                actions = {
//                    IconButton(onClick = { /*TODO*/ }) {
//                        Icon(imageVector = Icons.Filled.Delete, contentDescription = null)
//                    }
//                }
            )
        }
    ) { paddingScaffold ->
        Column(
            modifier = Modifier.padding(paddingScaffold)
        ) {
            val textState = remember { mutableStateOf(TextFieldValue()) }
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
                modifier = Modifier
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = { Text(text = "Name", style = TextStyles.textField) },

                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    JAFTATheme {
        SignupScreen()
    }
}