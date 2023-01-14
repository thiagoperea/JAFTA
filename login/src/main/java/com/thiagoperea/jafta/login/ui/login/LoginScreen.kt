package com.thiagoperea.jafta.login.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.ArrowTopAppBar
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.login.R

@Composable
fun LoginScreen(
    onNavigationUp: () -> Unit,
) {
    Scaffold(
        topBar = {
            ArrowTopAppBar(
                text = stringResource(id = R.string.login),
                onNavigateUp = onNavigationUp
            )
        }
    ) { paddingScaffold ->

        Column(
            modifier = Modifier.padding(paddingScaffold)
        ) {

            val emailState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }
            var showPassword by remember { mutableStateOf(false) }


            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                modifier = Modifier
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
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

            OutlinedTextField(
                value = passwordState.value,
                onValueChange = { passwordState.value = it },
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.password),
                        style = TextStyles.title2
                    )
                },
                placeholder = { Text(text = stringResource(id = R.string.enter_your_password)) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Lock Icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                            contentDescription = if (showPassword) "Show Password" else "Hide Password"
                        )
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            CustomButton(
                text = stringResource(id = R.string.login),
                type = CustomButtonType.PRIMARY,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 48.dp),
                onClick = { TODO() }
            )

            Text(
                text = stringResource(id = R.string.forgot_password),
                style = TextStyles.title3,
                color = Violet100,
                modifier = Modifier
                    .padding(top = 33.dp, bottom = 38.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = TextStyles.spannableString(
                        text = stringResource(id = R.string.dont_have_an_account_yet),
                        textSpan = stringResource(id = R.string.signup)
                    ),
                    style = TextStyles.title4
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    JAFTATheme {
        LoginScreen(onNavigationUp = { })
    }
}