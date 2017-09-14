package com.tuvy.tomosugi.minimalpairs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import com.tuvy.tomosugi.minimalpairs.controller.MainFragmentStatePagerAdapter


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val viewPager = findViewById(R.id.pager) as ViewPager
        viewPager.adapter = MainFragmentStatePagerAdapter(supportFragmentManager)
    }
}
