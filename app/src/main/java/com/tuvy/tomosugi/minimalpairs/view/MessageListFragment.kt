package com.tuvy.tomosugi.minimalpairs.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuvy.tomosugi.minimalpairs.R

/**
 * Created by tomosugi on 2017/09/11.
 */

class MessageListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.message_list, null)
    }
}