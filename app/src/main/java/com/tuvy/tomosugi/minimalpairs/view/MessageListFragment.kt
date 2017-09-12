package com.tuvy.tomosugi.minimalpairs.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.tuvy.tomosugi.minimalpairs.MessageActivity
import com.tuvy.tomosugi.minimalpairs.R

/**
 * Created by tomosugi on 2017/09/11.
 */

class MessageListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.message_list, null)
    }

    override fun onStart() {
        super.onStart()

        val testButton: Button
        testButton = activity.findViewById(R.id.testButton) as Button

        testButton.text = "test"

        testButton.setOnClickListener {

            val intent: Intent
            intent = Intent(activity, MessageActivity::class.java)

            startActivity(intent)
        }
    }
}