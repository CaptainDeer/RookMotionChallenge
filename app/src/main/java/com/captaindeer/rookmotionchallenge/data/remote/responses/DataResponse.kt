package com.captaindeer.rookmotionchallenge.data.remote.responses

import com.google.gson.annotations.SerializedName

data class DataResponse(
    @SerializedName("id") var id: Int,
    @SerializedName("email") var email: String,
    @SerializedName("first_name") var first_name: String,
    @SerializedName("last_name") var last_name: String,
    @SerializedName("avatar") var avatar: String
)
