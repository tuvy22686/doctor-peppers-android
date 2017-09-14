package com.tuvy.tomosugi.minimalpairs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.TextView
import com.tuvy.tomosugi.minimalpairs.controller.ChatRecyclerViewAdapter
import com.tuvy.tomosugi.minimalpairs.model.Message

class ChatActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val rv = findViewById(R.id.massageRecyclewView) as RecyclerView
        val llm = LinearLayoutManager(this)

//        val data: List<Message> = List(3, { index -> Message(index.toString())})
        val data: List<Message> = List(3, { index -> Message(partnerName = "太郎" , message = "へけっ\nへけっ\nへけっ\nへけっ\nへけっ\nへけっ")})

        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = ChatRecyclerViewAdapter(data)

    }
}
