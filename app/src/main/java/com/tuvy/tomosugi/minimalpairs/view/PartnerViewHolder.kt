package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import com.tuvy.tomosugi.minimalpairs.R

/**
 * Created by tomosugi on 2017/09/12.
 */

class PartnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var partnerView: Button

    init {
        partnerView = itemView.findViewById(R.id.user_id) as Button
    }
}