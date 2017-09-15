package com.tuvy.tomosugi.minimalpairs.controller

import android.util.Log
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.tuvy.tomosugi.minimalpairs.model.HistoryMessage
import com.tuvy.tomosugi.minimalpairs.model.Status
import com.tuvy.tomosugi.minimalpairs.model.User
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by tomosugi on 2017/09/14.
 */

class MinimalPairsClient {

    private val endpoint: String = "https://guarded-garden-55846.herokuapp.com/api/"
    private val okHttpClient = OkHttpClient.Builder()
            .addNetworkInterceptor(StethoInterceptor())
            .build()

    fun history(userId: Int, partnerId: Int): io.reactivex.Observable<HistoryMessage> {
        Log.d("Clinet.history", "check")
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
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
                .client(okHttpClient)
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        Log.d("Client.post", "retrofit build ok")

        val userIdPart = MultipartBody.create(MediaType.parse("text/plain"), userId.toString())
        val partnerIdPart = MultipartBody.create(MediaType.parse("text/plain"), partnerId.toString())
        val textPart = MultipartBody.create(MediaType.parse("text/plain"), text)

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.post(userId = userIdPart, partnerId = partnerIdPart, text = textPart)
    }

    fun getProfile2(): io.reactivex.Observable<User> {
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.getProfile2()
    }

    fun getProfile3(): io.reactivex.Observable<User> {
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.getProfile3()
    }

    fun getProfile4(): io.reactivex.Observable<User> {
        val retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api = retrofit.create(MinimalPairsApi::class.java)
        return api.getProfile4()
    }

    interface MinimalPairsApi {
        @GET("message/history")
        fun history(
                @Query("user_id") userId: Int,
                @Query("partner_id") partnerId: Int
        ): io.reactivex.Observable<HistoryMessage>

        @Multipart
        @POST("message/create")
        fun post(
                @Part("user_id") userId: RequestBody,
                @Part("partner_id") partnerId: RequestBody,
                @Part("content") text: RequestBody
        ): io.reactivex.Observable<Status>

        @GET("user/2")
        fun getProfile2(): io.reactivex.Observable<User>

        @GET("user/3")
        fun getProfile3(): io.reactivex.Observable<User>

        @GET("user/4")
        fun getProfile4(): io.reactivex.Observable<User>
    }
}