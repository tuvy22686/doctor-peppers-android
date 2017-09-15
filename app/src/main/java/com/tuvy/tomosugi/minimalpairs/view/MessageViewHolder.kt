package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.tuvy.tomosugi.minimalpairs.R

class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var messageView: TextView
    var partnerIcon: ImageView

    init {
        messageView = itemView.findViewById(R.id.message) as TextView
        partnerIcon = itemView.findViewById(R.id.chat_partner_icon) as ImageView
    }
}