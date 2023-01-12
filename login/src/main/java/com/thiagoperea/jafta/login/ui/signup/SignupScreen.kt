package com.thiagoperea.jafta.login.ui.signup

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.login.R

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.signup),
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
                label = {
                    Text(
                        text = stringResource(id = R.string.name),
                        style = TextStyles.title2
                    )
                },
            )
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
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
            )
            OutlinedTextField(
                value = textState.value,
                onValueChange = { textState.value = it },
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
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(start = 20.dp, top = 17.dp, end = 26.dp)
            ) {
                val checkedState = remember { mutableStateOf(false) }
                Checkbox(
                    checked = checkedState.value,
                    onCheckedChange = { checkedState.value = it },
                    colors = CheckboxDefaults.colors(
                        uncheckedColor = Violet100,
                        checkedColor = Violet100
                    )
                )
                Text(
                    text = stringResource(id = R.string.terms_of_service_and_privacy_policy),
                    style = TextStyles.body3
                )
            }
            CustomButton(
                text = stringResource(id = R.string.signup),
                type = CustomButtonType.PRIMARY,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp, top = 24.dp),
            ) {

            }
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
                    Text(
                        modifier = Modifier.padding(vertical = 4.dp),
                        text = "Sign Up with Google",
                        style = TextStyles.title3,
                        color = Color.Black
                    )
                },
                shape = RoundedCornerShape(16.dp),
                elevation = ButtonDefaults.elevation(0.dp, 0.dp, 0.dp, 0.dp, 0.dp)
            )
            Row() {
                Text(
                    text = stringResource(id = R.string.already_have_an_account),
                    style = TextStyles.title4,
                    modifier = Modifier
                        .padding(top = 16.dp),
                    textAlign = TextAlign.Center,
                    color = Light20
                )

                Text(
                    text = stringResource(id = R.string.login),
                    style = TextStyles.title4,
                    color = Violet100,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 4.dp)
                        .fillMaxWidth(),
                )
            }
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