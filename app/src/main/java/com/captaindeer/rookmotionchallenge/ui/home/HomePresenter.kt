package com.captaindeer.rookmotionchallenge.ui.home

import android.content.Context
import com.captaindeer.rookmotionchallenge.data.local.LocalDatabase
import com.captaindeer.rookmotionchallenge.data.local.entities.UserEntity
import com.captaindeer.rookmotionchallenge.data.remote.RetrofitBuilder
import com.captaindeer.rookmotionchallenge.utils.OnLine
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class HomePresenter(private val context: Context, private val view: HomeInterface.View) :
    HomeInterface.Presenter, CoroutineScope {

    private var retrofit = RetrofitBuilder()
    private val database = LocalDatabase(context)
    private val job = Job()
    override val coroutineContext: CoroutineContext = job + Dispatchers.IO

    override fun getAllUsers() {
        if (OnLine.isNetworkAvailable(context)) {
            launch {
                retrofit = RetrofitBuilder()
                val response = retrofit.getAllUsers()
                if (response.isSuccessful) {
                    response.body()?.data?.forEach { user ->
                        database.userDao().insert(
                            UserEntity(
                                user.id,
                                user.first_name,
                                user.last_name,
                                user.email,
                                user.avatar
                            )
                        )
                    }
                    withContext(Dispatchers.Main) {
                        view.setListUsers(database.userDao().updatePosts() as ArrayList)
                    }
                    withContext(Dispatchers.Main) {
                        view.setListUsers(database.userDao().updatePosts() as ArrayList)
                    }
                } else {
                    view.onError(response.errorBody().toString())
                }
            }
        } else {
            view.onError("No internet detected.")
            view.setListUsers(database.userDao().updatePosts() as ArrayList)
        }
    }

    override fun getAllUsersAgain(): List<UserEntity> {
        return database.userDao().getAllUsersAgain()
    }

    override fun getUser(user: String): List<UserEntity> {
        return database.userDao().getUser(user)
    }

    override fun onCancel() {
        job.cancel()
    }

}