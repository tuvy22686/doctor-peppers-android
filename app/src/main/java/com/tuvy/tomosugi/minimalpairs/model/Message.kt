package com.tuvy.tomosugi.minimalpairs.model

import com.google.gson.annotations.SerializedName

data class Message (
        @SerializedName("user_id") val userId: Int,
        @SerializedName("partner_id") val partnerId: Int,
        @SerializedName("from_me") val fromMe: Int,
        @SerializedName("content") val text: String,
        @SerializedName("created_at") val timestamp: Int
)