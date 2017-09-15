package com.tuvy.tomosugi.minimalpairs.model

import com.google.gson.annotations.SerializedName

/**
 * Created by tomosugi on 2017/09/14.
 */

data class HistoryMessage (
        @SerializedName("user_id") val userId: Int,
        @SerializedName("partner_id") val partnerId: Int,
        @SerializedName("messages") val messages: List<Message>
)