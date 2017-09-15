package com.tuvy.tomosugi.minimalpairs

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import com.tuvy.tomosugi.minimalpairs.controller.ChatRecyclerViewAdapter
import com.tuvy.tomosugi.minimalpairs.controller.MinimalPairsClient
import de.hdodenhof.circleimageview.CircleImageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rm.com.longpresspopup.LongPressPopupBuilder
import java.sql.Time
import java.util.*

class ChatActivity : AppCompatActivity() {

    var client = MinimalPairsClient()
    var rv: RecyclerView? = null
    var llm: LinearLayoutManager? = null

    var mHandler = Handler()
    var mTimer = Timer()

//    var circleImageView: CircleImageView? = null
//    circleImageView!!.setImageResource(R.drawable.girl2_green)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Congratuations画面
        setContentView(R.layout.congratulations)

        var kimochiButton: Button? = findViewById(R.id.kimochi_button) as Button
        var cancelButton: ImageButton? = findViewById(R.id.cancel_button) as ImageButton

        //「気持ちを伝える」ボタンを押して遷移
        kimochiButton!!.setOnClickListener {
            setContentView(R.layout.activity_chat_first)

            var iine_item: ImageView = findViewById(R.id.iine_item) as ImageView
            var wadai_item: ImageView = findViewById(R.id.wadai_item) as ImageView
            var orei_item: ImageView = findViewById(R.id.orei_item) as ImageView
            var shitumon_item: ImageView = findViewById(R.id.shitumon_item) as ImageView


            var popup_iine_item = LongPressPopupBuilder(this)
                    .setTarget(iine_item)
                    .setPopupView(LayoutInflater.from(this).inflate(R.layout.popup_iine_item, null, true))
                    .build()
            popup_iine_item.register()

            var popup_wadai_item = LongPressPopupBuilder(this)
                    .setTarget(wadai_item)
                    .setPopupView(LayoutInflater.from(this).inflate(R.layout.popup_wadai_item, null, true))
                    .build()
            popup_wadai_item.register()

            var popup_orei_item = LongPressPopupBuilder(this)
                    .setTarget(orei_item)
                    .setPopupView(LayoutInflater.from(this).inflate(R.layout.popup_orei_item, null, true))
                    .build()
            popup_orei_item.register()

            var popup_shitumon_item = LongPressPopupBuilder(this)
                    .setTarget(shitumon_item)
                    .setPopupView(LayoutInflater.from(this).inflate(R.layout.popup_shitumon_item, null, true))
                    .build()
            popup_shitumon_item.register()

            var cancelButton2: ImageButton = findViewById(R.id.first_cancel_button) as ImageButton
            cancelButton2.setOnClickListener {
                onClickCancelButton()
            }
        }

        //「キャンセル」ボタンを押して遷移
        cancelButton!!.setOnClickListener {
            onClickCancelButton()
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

    fun onClickCancelButton() {
        setContentView(R.layout.activity_chat)

        autoReload()

        rv = findViewById(R.id.massageRecyclewView) as RecyclerView
        llm = LinearLayoutManager(this)


        val messageEditText: EditText = findViewById(R.id.message_edit_text) as EditText
        val sendButton: Button = findViewById(R.id.send_button) as Button

        sendButton.setOnClickListener {

            //messageEditText.text.toString()
            client.postAlt(userId = 1, partnerId = 2, text = messageEditText.text.toString())
                    .subscribeOn(Schedulers.io())
                    .subscribe {
                        Log.d("post", it.status)
                        history()
//                        messageEditText.editableText.clear()
                    }
        }






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


//                    //会話履歴取得用API(テスト)
//        client.history(userId = 1, partnerId = 2)
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
//
//                }

//            var editText: EditText = findViewById(R.id.message_edit_text) as EditText
//            editText.setOnFocusChangeListener

//            editText.setOnFocusChangeListener { v, hasFocus ->
//                if (hasFocus) {
//                    //ビューの変更
//                    var linearLayout: LinearLayout = findViewById(R.id.before_bottombar) as LinearLayout
//                    linearLayout.removeAllViews()
//                    layoutInflater.inflate(R.layout.after_buttombar, linearLayout)
//                    //変わったあとの後のビューのedittextにフォーカスを当てる
//                    var afterEditText: EditText = findViewById(R.id.after_message_edittext) as EditText
//                    afterEditText.isFocusable = true
//                    afterEditText.isFocusableInTouchMode = true
//                    afterEditText.requestFocus()
//
//                } else {
//
//                }
//            }


        val toolbar: android.support.v7.widget.Toolbar = findViewById(R.id.toolbar) as android.support.v7.widget.Toolbar
        setSupportActionBar(toolbar)

        var intent = intent
        var partnerId: Int = intent.getIntExtra("partnerId", -1)
        var partnerName = when (partnerId) {
            0 -> "Yuka"
            1 -> "aki"
            2 -> "Sayuri"
            else -> "null子"
        }

        //Toolbarのカスタマイズ
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(resizeDrawable(resources.getDrawable(R.drawable.arrow)))
        supportActionBar?.title = partnerName

//            var inflator: LayoutInflater = supportActionBar.themedContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            var customActionBarView = inflator.inflate(R.layout.toolbar_icon)
//
//            supportActionBar?.customView(LayoutInflater.from(this).inflate(R.layout.toolbar_icon))

//            R.layout.toolbar_icon

        toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

//            if (intent != null) {
//                Log.d("onCreate", intent.getIntExtra("partnerId", -1).toString())
//            }

//            val rv = findViewById(R.id.massageRecyclewView) as RecyclerView
//            val llm = LinearLayoutManager(this)

//        val data: List<Message> = List(3, { index -> Message(index.toString())})
        //TODO ダミーなので、historyを呼び出して入れる
//            val data: List<Message> = List(3, { timestamp -> Message(partnerId = 1, userId = 2, fromMe = 1, timestamp = timestamp, text = "hello") })

//            rv.setHasFixedSize(true)
//            rv.layoutManager = llm
//            rv.adapter = ChatRecyclerViewAdapter(data)


    }

    fun history() {
        client.history(userId = 1, partnerId = 2)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    Log.d("history", "Hello")
                    rv!!.setHasFixedSize(true)
                    rv!!.layoutManager = llm
                    rv!!.adapter = ChatRecyclerViewAdapter(it.messages)
                }
    }

    fun autoReload() {
        mTimer.schedule(object : TimerTask() {
            override fun run() {
                mHandler.post(Runnable {
                    history()
                })
            }
        }, 1000, 5000) // 実行したい間隔(ミリ秒)
    }

    override fun onPause() {
        super.onPause()

        if (mTimer != null) {
            mTimer.cancel()
        }
    }

}
