package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.tuvy.tomosugi.minimalpairs.R

class PartnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var layout: LinearLayout
    var partnerName: TextView
    var partnerStatus: TextView
    var partnerTimeStamp: TextView
    var partnerIcon: ImageView

    init {
        layout = itemView.findViewById(R.id.partner) as LinearLayout
        partnerName = itemView.findViewById(R.id.user_name) as TextView
        partnerStatus = itemView.findViewById(R.id.user_status) as TextView
        partnerTimeStamp = itemView.findViewById(R.id.user_timestamp) as TextView
        partnerIcon = itemView.findViewById(R.id.user_icon) as ImageView
    }
}