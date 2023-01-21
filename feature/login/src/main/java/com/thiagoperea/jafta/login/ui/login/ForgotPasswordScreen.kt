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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.ArrowTopAppBar
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.login.R

@Composable
fun ForgotPasswordScreen(
    onNavigationUp: () -> Unit,
    sendEmail: () -> Unit
) {

    Scaffold(
        topBar = {
            ArrowTopAppBar(
                text = stringResource(id = R.string.title_forgot_password),
                onNavigateUp = { onNavigationUp }
            )
        }
    ) { paddingScaffold ->

        Column(
            modifier = Modifier.padding(paddingScaffold)
        ) {

            val emailState = remember { mutableStateOf("") }

            Text(
                text = stringResource(id = R.string.enter_your_email_and_well_send_you_a_link),
                modifier = Modifier
                    .padding(top = 69.dp, start = 16.dp, end = 16.dp),
                style = TextStyles.semiBold24,
                textAlign = TextAlign.Start,
                maxLines = 4
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                modifier = Modifier
                    .padding(top = 36.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.email),
                        style = TextStyles.title2
                    )
                },
                placeholder = { Text(text = stringResource(id = R.string.enter_your_email)) }
            )

            CustomButton(
                text = stringResource(id = R.string.continue_button),
                type = CustomButtonType.PRIMARY,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 48.dp),
                onClick = { sendEmail() }
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    JAFTATheme {
        ForgotPasswordScreen(onNavigationUp = {}, sendEmail = {})
    }
}