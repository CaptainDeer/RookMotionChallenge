package com.captaindeer.rookmotionchallenge.ui.registry

import android.net.Uri
import com.captaindeer.rookmotionchallenge.data.remote.models.UserModel

interface RegistryInterface {
    interface View{
        fun onSuccess()
        fun onError(msg:String)
    }
    interface Presenter{
        fun setNewUser(email:String, password:String)
    }
}