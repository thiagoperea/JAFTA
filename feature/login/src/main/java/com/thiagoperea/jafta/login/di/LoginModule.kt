package com.thiagoperea.jafta.login.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.thiagoperea.jafta.login.ui.signup.viewModel.SignupViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {

    single {
        Firebase.auth
    }

    viewModel {
        SignupViewModel(get())
    }

}
