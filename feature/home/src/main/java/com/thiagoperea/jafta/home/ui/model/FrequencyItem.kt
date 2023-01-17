package com.thiagoperea.jafta.home.ui.model

import androidx.annotation.StringRes

data class FrequencyItem(
    @StringRes val frequency: Int,
    val isEnabled: Boolean
)