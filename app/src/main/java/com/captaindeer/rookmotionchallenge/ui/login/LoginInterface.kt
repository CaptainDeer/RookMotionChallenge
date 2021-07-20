package com.captaindeer.rookmotionchallenge.ui.login

interface LoginInterface {

    interface View {
        fun onSuccess()
        fun onError(msg: String)
    }

    interface Presenter {
        fun goToLogin(email: String, password: String)
    }
}