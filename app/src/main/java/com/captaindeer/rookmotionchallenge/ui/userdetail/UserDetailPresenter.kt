package com.captaindeer.rookmotionchallenge.ui.userdetail

import android.content.Context
import com.captaindeer.rookmotionchallenge.data.local.LocalDatabase

class UserDetailPresenter(
    private val context: Context,
    private val view: UserDetailInterface.View
) : UserDetailInterface.Presenter {

    private val database = LocalDatabase(context)

    override fun getUserDetail(id: Int) {
        view.setUserInfo(database.userDao().getUserDetail(id))
    }


}