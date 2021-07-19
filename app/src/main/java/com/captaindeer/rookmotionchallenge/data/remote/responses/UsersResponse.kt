package com.captaindeer.rookmotionchallenge.data.remote.responses

import com.google.gson.annotations.SerializedName

data class UsersResponse(
    @SerializedName("page") var page: Int,
    @SerializedName("per_page") var per_page: Int,
    @SerializedName("total") var total: Int,
    @SerializedName("total_pages") var total_pages: Int,
    @SerializedName("data") var data: List<DataResponse>
)
