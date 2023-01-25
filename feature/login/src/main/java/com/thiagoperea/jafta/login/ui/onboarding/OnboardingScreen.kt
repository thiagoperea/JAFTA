package com.thiagoperea.jafta.login.ui.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState
import com.thiagoperea.jafta.design_system.button.CustomButton
import com.thiagoperea.jafta.design_system.button.CustomButtonType
import com.thiagoperea.jafta.design_system.theme.Violet100
import com.thiagoperea.jafta.design_system.theme.Violet20
import com.thiagoperea.jafta.login.R
import com.thiagoperea.jafta.login.ui.onboarding.views.OnboardingPagerItem

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnboardingScreen(
    goToSignup: () -> Unit,
    goToLogin: () -> Unit
) {

    val pagerState = rememberPagerState()

    val pages = listOf(
        OnboardingScreenPage(R.drawable.ic_gain_control, R.string.gain_control_title, R.string.gain_control_description),
        OnboardingScreenPage(R.drawable.ic_bills, R.string.know_where_your_money_title, R.string.know_where_your_money_description),
        OnboardingScreenPage(R.drawable.ic_plans, R.string.planning_title, R.string.planning_description)
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            modifier = Modifier
                .weight(1f)
                .padding(top = 32.dp),
            state = pagerState,
            count = pages.size
        ) { pageIndex ->

            val pageDetails = pages[pageIndex]
            OnboardingPagerItem(data = pageDetails)
        }

        HorizontalPagerIndicator(
            modifier = Modifier.padding(vertical = 32.dp),
            pagerState = pagerState,
            inactiveColor = Violet20,
            activeColor = Violet100,
        )

        CustomButton(
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            type = CustomButtonType.PRIMARY,
            text = stringResource(R.string.signup),
            onClick = { goToSignup() }
        )

        CustomButton(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp),
            type = CustomButtonType.SECONDARY,
            text = stringResource(R.string.login),
            onClick = { goToLogin() }
        )
    }
}

data class OnboardingScreenPage(
    @DrawableRes val imageRes: Int,
    @StringRes val titleRes: Int,
    @StringRes val descriptionRes: Int
)
