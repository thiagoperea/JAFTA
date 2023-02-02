package com.thiagoperea.jafta.login.ui.setupAccount

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thiagoperea.jafta.design_system.CustomButton
import com.thiagoperea.jafta.design_system.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.Dark25
import com.thiagoperea.jafta.design_system.theme.Dark50
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.login.R

@Composable
fun LetsSetupAccount() {

    Column {

        Text(
            text = stringResource(R.string.lets_setup_your_account),
            modifier = Modifier.padding(top = 67.dp, start = 16.dp, end = 16.dp),
            style = TextStyles.medium36,
            color = Dark50
        )

        Text(
            text = stringResource(R.string.account_can_be_your_bank_credit_card_or_your_wallet),
            modifier = Modifier.padding(top = 37.dp, start = 16.dp, end = 16.dp),
            style = TextStyles.body3,
            color = Dark25
        )

        CustomButton(text = stringResource(R.string.lets_go),
            type = CustomButtonType.PRIMARY,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 434.dp),
            onClick = { })
    }
}

@Preview
@Composable
fun SetupPinScreenPreview() {
    JAFTATheme {
        LetsSetupAccount()
    }
}