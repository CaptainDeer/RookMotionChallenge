package com.captaindeer.rookmotionchallenge.ui.home

import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity

interface HomeInterface {
    interface View {
        fun setListUsers(users: ArrayList<UserEntity>)
        fun onError(msg: String)
    }

    interface Presenter {
        fun getAllUsers()
        fun getAllUsersAgain(): List<UserEntity>
        fun getUser(user: String): List<UserEntity>
        fun onCancel()
    }
}