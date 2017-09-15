package com.tuvy.tomosugi.minimalpairs.view

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.tuvy.tomosugi.minimalpairs.R

class MosaicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mosaicView: ImageView
    var partnerIcon: ImageView

    init {
        mosaicView = itemView.findViewById(R.id.mosaic_view) as ImageView
        partnerIcon = itemView.findViewById(R.id.chat_partner_icon) as ImageView
    }
}