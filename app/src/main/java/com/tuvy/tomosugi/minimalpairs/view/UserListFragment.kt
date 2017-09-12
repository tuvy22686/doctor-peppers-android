package com.tuvy.tomosugi.minimalpairs.view

import android.os.Bundle
import android.support.v4.app.Fragment

import com.tuvy.tomosugi.minimalpairs.R
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View




class UserListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.user_list, null)
    }
}
