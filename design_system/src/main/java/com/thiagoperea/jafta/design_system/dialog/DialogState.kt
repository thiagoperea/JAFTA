package com.thiagoperea.jafta.design_system.dialog

import androidx.annotation.StringRes

sealed class DialogState {
    object Dismissed : DialogState()

    data class Loading(@StringRes val messageRes: Int) : DialogState()

    data class Success(@StringRes val messageRes: Int) : DialogState()

    data class Failure(@StringRes val messageRes: Int) : DialogState()
}