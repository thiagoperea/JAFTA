package com.thiagoperea.jafta.login.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.Dark100
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.login.R

@Composable
fun ShippingConfirmationScreen(
    goToResetPassword: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_shipping),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .padding(top = 32.dp, start = 32.dp, end = 32.dp)
                .fillMaxSize()
        )

        Text(
            modifier = Modifier.padding(top = 18.dp, start = 24.dp, end = 24.dp),
            text = stringResource(id = R.string.your_email_is_on_the_way),
            style = TextStyles.semiBold24,
            color = Dark100,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp),
            text = stringResource(id = R.string.check_your_email),
            style = TextStyles.body1,
            color = Dark25,
            textAlign = TextAlign.Center,
            maxLines = 3
        )

        CustomButton(
            text = stringResource(id = R.string.back_to_login),
            type = CustomButtonType.PRIMARY,
            modifier = Modifier
                .padding(top = 190.dp, start = 16.dp, end = 16.dp, bottom = 50.dp),
            onClick = { goToResetPassword() }
        )
    }
}

@Preview
@Composable
fun ShippingConfirmationPreview() {
    JAFTATheme {
        ShippingConfirmationScreen(goToResetPassword = {})
    }
}