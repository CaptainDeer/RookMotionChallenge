package com.captaindeer.rookmotionchallenge.ui.registry

interface RegistryInterface {
    interface View {
        fun onSuccess()
        fun onError(msg: String)
    }

    interface Presenter {
        fun setNewUser(email: String, password: String)
    }
}