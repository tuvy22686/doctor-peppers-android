package com.tuvy.tomosugi.minimalpairs

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        var textView: TextView
        textView = findViewById(R.id.testTextView) as TextView
        textView.setText("test")
    }
}
