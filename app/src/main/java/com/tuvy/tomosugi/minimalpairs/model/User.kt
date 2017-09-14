package com.tuvy.tomosugi.minimalpairs.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tomosugi on 2017/09/12.
 */
data class User(
        @SerializedName("id") val id: Int,
        @SerializedName("user_name") val name: String,
        @SerializedName("gender") val gender: Int,
        @SerializedName("age") val age: Int,
        @SerializedName("job") val job: String
)