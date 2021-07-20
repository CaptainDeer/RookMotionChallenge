package com.captaindeer.rookmotionchallenge.ui.registry

import com.google.firebase.auth.FirebaseAuth

class RegistryPresenter(private val view: RegistryInterface.View) : RegistryInterface.Presenter {

    override fun setNewUser(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
        view.onSuccess()
    }
}