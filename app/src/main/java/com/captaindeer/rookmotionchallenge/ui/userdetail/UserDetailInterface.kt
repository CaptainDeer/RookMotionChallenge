package com.captaindeer.rookmotionchallenge.ui.userdetail

import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity

interface UserDetailInterface {
    interface View {
        fun setUserInfo(userEntity: UserEntity)
    }

    interface Presenter {
        fun getUserDetail(id: Int)
    }
}