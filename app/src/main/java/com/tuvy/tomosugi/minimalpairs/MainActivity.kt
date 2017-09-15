package com.tuvy.tomosugi.minimalpairs

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.facebook.stetho.Stetho
import com.tuvy.tomosugi.minimalpairs.controller.MainFragmentStatePagerAdapter
import com.tuvy.tomosugi.minimalpairs.controller.MinimalPairsClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private val client = MinimalPairsClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Stetho.initializeWithDefaults(this)

//        // メッセージ送信用API(テスト)
//        client.post(1, 2, "hello")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    Log.d("post", "doOnSubscribe")
//                }
//                .doOnError {
//                    Log.d("post", "doOnError")
//                }
//                .doOnNext {
//                    Log.d("post", "doOnNext")
//                }
//                .subscribe {
//                    Log.d("post", "subscribe")
//                }

//        // New: メッセージ送信用API(テスト)
//        client.postAlt(1, 2, "hello")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    Log.d("post", "doOnSubscribe")
//                }
//                .doOnError {
//                    Log.d("post", "doOnError")
//                }
//                .doOnNext {
//                    Log.d("post", "doOnNext")
//                }
//                .subscribe {
//                    Log.d("post", "subscribe")
//                    Log.d("post", it.status)
//                }

//        //プロフィール取得用API(テスト)
//        client.getProfile()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    Log.d("getProfile", "doOnSubscribe")
//                }
//                .doOnError {
//                    Log.d("getProfile", "doOnError")
//                }
//                .doOnNext {
//                    Log.d("getProfile", "doOnNext")
//                }
//                .subscribe {
//                    Log.d("getProfile", "subscribe")
//                    Log.d("getProfile", it.name)
//                }

        //会話履歴aa取得用API(テスト)
//        client.history(userId = 1, partnerId = 2)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    Log.d("history", "doOnSubscribe")
//                }
//                .doOnError {
//                    Log.d("history", "doOnError")
//                }
//                .doOnNext {
//                    Log.d("history", "doOnNext")
//                }
//                .subscribe {
//                    Log.d("history", "subscribe")
//                }


        setContentView(R.layout.activity_main)
        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager)
    }
}
