package com.tuvy.tomosugi.minimalpairs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import com.tuvy.tomosugi.minimalpairs.controller.MainFragmentStatePagerAdapter
import com.tuvy.tomosugi.minimalpairs.controller.MinimalPairsClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MainActivity : AppCompatActivity() {

    private val client = MinimalPairsClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        メッセージ送信用API(テスト)
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

//        プロフィール取得用API(テスト)
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

        setContentView(R.layout.activity_main)
        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager)
    }
}
