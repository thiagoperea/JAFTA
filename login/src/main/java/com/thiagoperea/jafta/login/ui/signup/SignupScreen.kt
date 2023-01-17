package com.thiagoperea.jafta.login.ui.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
import com.thiagoperea.jafta.login.ui.signup.viewModel.SignupViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    onNavigationUp: () -> Unit,
    viewModel: SignupViewModel = koinViewModel()
) {
    Scaffold(
        topBar = {
            ArrowTopAppBar(
                text = stringResource(id = R.string.signup),
                onNavigateUp = onNavigationUp
            )
        }
    ) { paddingScaffold ->

        Column(
            modifier = Modifier.padding(paddingScaffold)
        ) {

            val nameState = remember { mutableStateOf("") }
            val emailState = remember { mutableStateOf("") }
            val passwordState = remember { mutableStateOf("") }
            var showPassword by remember { mutableStateOf(false) }
            val checkedState = remember { mutableStateOf(false) }

            OutlinedTextField(
                value = nameState.value,
                onValueChange = { nameState.value = it },
                modifier = Modifier
                    .padding(top = 56.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.name),
                        style = TextStyles.title2
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_name)
                    )
                }
            )

            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it },
                modifier = Modifier
                    .padding(top = 24.dp, start = 16.dp, end = 16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                label = {
                    Text(
                        text = stringResource(id = R.string.email),
                        style = TextStyles.title2
                    )
                },
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_email)
                    )
                }
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
                placeholder = {
                    Text(
                        text = stringResource(id = R.string.enter_your_password)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword) Icons.Outlined.VisibilityOff else Icons.Outlined.Visibility,
                            contentDescription = null
                        )
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation()
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 20.dp, top = 17.dp, end = 26.dp)
            ) {

                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Violet100,
                        checkedColor = Violet100
                    )
                )

                Text(
                    text = TextStyles.spannableString(
                        stringResource(id = R.string.terms_of_service_and_privacy_policy),
                        stringResource(id = R.string.terms_of_service_and_privacy_policy_span_text)
                    ),
                    style = TextStyles.body3
                )
            }

            CustomButton(
                text = stringResource(id = R.string.signup),
                type = CustomButtonType.PRIMARY,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp),
                onClick = { viewModel.signup(emailState.value, passwordState.value) }
            )

            Text(
                text = stringResource(id = R.string.or_with),
                style = TextStyles.title5,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            OutlinedButton(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                onClick = { TODO() },
                content = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            imageVector = ImageVector.vectorResource(id = R.drawable.ic_google),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(end = 10.dp)
                        )
                        Text(
                            modifier = Modifier.padding(vertical = 4.dp),
                            text = stringResource(id = R.string.sign_up_with_google),
                            style = TextStyles.title3,
                            color = Color.Black
                        )
                    }
                },
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {

                Text(
                    text = TextStyles.spannableString(
                        text = stringResource(id = R.string.already_have_an_account),
                        textSpan = stringResource(id = R.string.login)
                    ),
                    style = TextStyles.title4,
                    modifier = Modifier
                        .padding(top = 16.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ItemPreview() {
    JAFTATheme {
        SignupScreen(onNavigationUp = { })
    }
}