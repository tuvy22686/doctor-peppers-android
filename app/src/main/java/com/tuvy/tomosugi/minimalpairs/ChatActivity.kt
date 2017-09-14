package com.tuvy.tomosugi.minimalpairs

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Matrix
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.graphics.drawable.ScaleDrawable
import android.media.Image
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.res.ResourcesCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.tuvy.tomosugi.minimalpairs.controller.ChatRecyclerViewAdapter
import com.tuvy.tomosugi.minimalpairs.model.Message
import rm.com.longpresspopup.LongPressPopup
import rm.com.longpresspopup.LongPressPopupBuilder

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Congratuations画面
        setContentView(R.layout.congratulations)

        var kimochiButton: Button = findViewById(R.id.kimochi_button) as Button
        var cancelButton: ImageButton = findViewById(R.id.cancel_button) as ImageButton

        //「気持ちを伝える」ボタンを押して遷移
        kimochiButton.setOnClickListener {
            setContentView(R.layout.activity_chat_first)

//            var popup = LongPressPopupBuilder(this)
//                    .setTarget(btn)
//                    //.setPopupView(textView)// Not using this time
//                    .setPopupView(R.layout.popup_layout, this)
//                    .setLongPressDuration(750)
//                    .setDismissOnLongPressStop(false)
//                    .setDismissOnTouchOutside(false)
//                    .setDismissOnBackPressed(false)
//                    .setCancelTouchOnDragOutsideView(true)
//                    .setLongPressReleaseListener(this)
//                    .setOnHoverListener(this)
//                    .setPopupListener(this)
//                    .setTag("PopupFoo")
//                    .setAnimationType(LongPressPopup.ANIMATION_TYPE_FROM_CENTER)
//                    .build();
//
//            onViewIn
        }

        //「キャンセル」ボタンを押して遷移
        cancelButton.setOnClickListener {
            setContentView(R.layout.activity_chat)

            val toolbar: android.support.v7.widget.Toolbar = findViewById(R.id.toolbar) as android.support.v7.widget.Toolbar
            setSupportActionBar(toolbar)

            var intent = intent
            var partnerId: Int = intent.getIntExtra("partnerId", -1)
            var partnerName = when (partnerId) {
                0 -> "零マン"
                1 -> "おとこ"
                2 -> "おんな"
                else -> "null子"
            }
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setHomeAsUpIndicator(resizeDrawable(resources.getDrawable(R.drawable.arrow)))
            supportActionBar?.title = partnerName
            toolbar.setNavigationOnClickListener {
                onBackPressed()
            }

            if (intent != null) {
                Log.d("onCreate", intent.getIntExtra("partnerId", -1).toString())
            }

            val rv = findViewById(R.id.massageRecyclewView) as RecyclerView
            val llm = LinearLayoutManager(this)

//        val data: List<Message> = List(3, { index -> Message(index.toString())})
            val data: List<Message> = List(3, { timestamp -> Message(partnerId = 1, userId = 2, fromMe = 1, timestamp = timestamp, text = "hello") })

            rv.setHasFixedSize(true)
            rv.layoutManager = llm
            rv.adapter = ChatRecyclerViewAdapter(data)


        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_chat, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        var id: Int = item!!.itemId
        if (id == R.id.action_setting) {
            return true
        }
        return super.onOptionsItemSelected(item);
    }


    fun resizeDrawable(drawable: Drawable): Drawable {
        var b: Bitmap = (drawable as BitmapDrawable).bitmap
        var bitmapResized = Bitmap.createScaledBitmap(b, 50, 50, false)
        return BitmapDrawable(resources, bitmapResized)
    }


}
