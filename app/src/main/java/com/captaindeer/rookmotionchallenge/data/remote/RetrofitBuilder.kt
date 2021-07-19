package com.captaindeer.rookmotionchallenge.data.remote

import com.captaindeer.rookmotionchallenge.data.remote.responses.UsersResponse
import com.captaindeer.rookmotionchallenge.data.remote.services.APIService
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    private val client = OkHttpClient.Builder().build()

    private lateinit var apiServices: APIService

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://reqres.in/")
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()

    suspend fun getAllUsers(): Response<UsersResponse> {
        apiServices = retrofit.create(APIService::class.java)
        return apiServices.getAllUsers()
    }
}