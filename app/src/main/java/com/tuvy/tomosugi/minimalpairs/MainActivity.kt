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

//        client.post(1, 2, "from Android")
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe {
//                    Log.d("Main.post", "doOnSubscribe")
//                }
//                .doOnError {
//                    Log.d("Main.post", "doOnError")
//                }
//                .doOnNext {
//                    Log.d("Main.post", "doOnNext")
//                }
//                .subscribe {
//                    Log.d("Main.post", "subscribe")
//                }

        setContentView(R.layout.activity_main)
        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager)
    }
}
