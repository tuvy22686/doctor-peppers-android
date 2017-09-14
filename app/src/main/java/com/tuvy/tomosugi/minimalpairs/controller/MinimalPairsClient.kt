package com.tuvy.tomosugi.minimalpairs.controller

import android.util.Log
import com.tuvy.tomosugi.minimalpairs.model.HistoryMessage
import com.tuvy.tomosugi.minimalpairs.model.Message
import com.tuvy.tomosugi.minimalpairs.model.Status
import com.tuvy.tomosugi.minimalpairs.model.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by tomosugi on 2017/09/14.
 */

class MinimalPairsClient {

    private val endpoint: String = "https://guarded-garden-55846.herokuapp.com/api/"

    fun history(userId: Int, partnerId: Int): io.reactivex.Observable<HistoryMessage> {
        val retrofit = Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.history(userId = userId, partnerId = partnerId)
    }

    fun post(userId: Int, partnerId: Int, text: String): io.reactivex.Observable<Status> {
        Log.d("Client.post", "check")
        val retrofit = Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        Log.d("Client.post", "retrofit build ok")

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.post(userId = userId, partnerId = partnerId, text = text)
    }

    fun getProfile(): io.reactivex.Observable<User> {
        val retrofit = Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.getProfile()
    }

    interface MinimalPairsApi {
        @FormUrlEncoded
        @GET("message/history")
        fun history(
                @Query("user_id") userId: Int,
                @Query("partner_id") partnerId: Int
        ): io.reactivex.Observable<HistoryMessage>

        @FormUrlEncoded
        @POST("message/create")
        fun post(
                @Field("user_id") userId: Int,
                @Field("partner_id") partnerId: Int,
                @Field("content") text: String
        ): io.reactivex.Observable<Status>

        @GET("user/1")
        fun getProfile(): io.reactivex.Observable<User>
    }
}