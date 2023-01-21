package com.thiagoperea.jafta.login.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.ArrowTopAppBar
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.login.R

@Composable
fun ResetPasswordScreen(
    onNavigationUp: () -> Unit
) {

    Scaffold(topBar = {
        ArrowTopAppBar(
            text = stringResource(id = R.string.reset_password), onNavigateUp = onNavigationUp
        )
    }) { paddingScaffold ->

        Column(
            modifier = Modifier.padding(paddingScaffold)
        ) {

            val newEmailState = remember { mutableStateOf("") }
            val newPasswordState = remember { mutableStateOf("") }

            OutlinedTextField(value = newEmailState.value,
                onValueChange = { newEmailState.value = it },
                modifier = Modifier
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.new_password), style = TextStyles.title2
                    )
                },
                placeholder = { Text(text = stringResource(id = R.string.enter_new_password)) })

            OutlinedTextField(value = newPasswordState.value,
                onValueChange = { newPasswordState.value = it },
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.retype_new_password),
                        style = TextStyles.title2
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.retype_new_password)
                    )
                })

            CustomButton(text = stringResource(id = R.string.continue_button),
                type = CustomButtonType.PRIMARY,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 32.dp),
                onClick = { })
        }
    }
}

@Preview
@Composable
fun ResetPasswordPreview() {
    JAFTATheme {
        ResetPasswordScreen(onNavigationUp = {})
    }
}