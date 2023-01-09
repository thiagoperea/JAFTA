package com.thiagoperea.jafta.login.ui.onboarding.views

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
import com.thiagoperea.jafta.design_system.theme.Dark50
import com.thiagoperea.jafta.design_system.theme.JAFTATheme
import com.thiagoperea.jafta.design_system.theme.Light20
import com.thiagoperea.jafta.design_system.theme.TextStyles
import com.thiagoperea.jafta.login.R
import com.thiagoperea.jafta.login.ui.onboarding.OnboardingScreenPage

@Composable
fun OnboardingPagerItem(
    data: OnboardingScreenPage
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(data.imageRes),
            contentDescription = null,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 32.dp)
        )

        Text(
            modifier = Modifier.padding(start = 48.dp, top = 32.dp, end = 48.dp),
            text = stringResource(data.titleRes),
            style = TextStyles.title1,
            color = Dark50,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(start = 48.dp, top = 8.dp, end = 48.dp),
            text = stringResource(data.descriptionRes),
            style = TextStyles.body1,
            color = Light20,
            textAlign = TextAlign.Center
        )

    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewOnboardingPagerItem() {
    JAFTATheme {
        OnboardingPagerItem(
            data = OnboardingScreenPage(R.drawable.ic_gain_control, R.string.gain_control_title, R.string.gain_control_description)
        )
    }
}