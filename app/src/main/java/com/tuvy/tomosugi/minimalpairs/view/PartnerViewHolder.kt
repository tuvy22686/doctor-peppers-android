package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.tuvy.tomosugi.minimalpairs.R

/**
 * Created by tomosugi on 2017/09/12.
 */

class PartnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var idView: TextView

    init {
        idView = itemView.findViewById(R.id.user_id) as TextView
    }
}