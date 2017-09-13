package com.tuvy.tomosugi.minimalpairs.view

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tuvy.tomosugi.minimalpairs.R
import com.tuvy.tomosugi.minimalpairs.controller.MatchingRecyclerViewAdapter
import com.tuvy.tomosugi.minimalpairs.model.User

/**
 * Created by tomosugi on 2017/09/11.
 */

class MatchingListFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.matching_list, null)
    }

    override fun onStart() {
        super.onStart()

        val rv = activity.findViewById(R.id.matchingRecyclerView) as RecyclerView
        val llm = LinearLayoutManager(context)

        // データセットの作成
        val data: List<User> = List(3, { index -> User(index) })

        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        rv.adapter = MatchingRecyclerViewAdapter(data)
    }
}