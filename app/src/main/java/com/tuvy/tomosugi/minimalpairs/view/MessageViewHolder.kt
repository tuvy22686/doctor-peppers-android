package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.tuvy.tomosugi.minimalpairs.R

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var messageView: TextView

    init {
        messageView = itemView.findViewById(R.id.message) as TextView
    }
}