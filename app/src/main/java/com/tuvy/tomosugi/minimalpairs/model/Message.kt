package com.tuvy.tomosugi.minimalpairs.model

import com.google.gson.annotations.SerializedName

data class Message (
        @SerializedName("partnerName") val partnerName: String,
        @SerializedName("message") val message: String
)