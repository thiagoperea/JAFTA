package com.thiagoperea.jafta.login.ui.signup.viewModel

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class SignupViewModel(val firebaseAuth: FirebaseAuth) : ViewModel() {

    fun signup(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // enviar para home
                    val user = firebaseAuth.currentUser
                    //updateUI(user)
                } else {
                    // mostrar error
                }
            }
    }
}