package com.captaindeer.rookmotionchallenge.ui.registry

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import java.util.*

class RegistryPresenter(private val view: RegistryInterface.View): RegistryInterface.Presenter {

    override fun setNewUser(email: String, password: String) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
            view.onSuccess()
    }
}