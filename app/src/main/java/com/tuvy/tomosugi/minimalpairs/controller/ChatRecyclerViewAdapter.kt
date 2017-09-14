package com.tuvy.tomosugi.minimalpairs.controller

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.tuvy.tomosugi.minimalpairs.ChatActivity
import com.tuvy.tomosugi.minimalpairs.R
import com.tuvy.tomosugi.minimalpairs.model.Message
import com.tuvy.tomosugi.minimalpairs.view.MessageViewHolder

class ChatRecyclerViewAdapter(private val data: List<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val inflate: View
        inflate = LayoutInflater.from(parent.context).inflate(R.layout.message, parent, false)
        return MessageViewHolder(inflate)
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as MessageViewHolder
        holder.messageView.text = data[position].text

//        holder.userIconView.setImageBitmap(list[position].bitmap)


//        if (data[position].partnerId == 0) {
//            holder.partnerIcon = LayoutInflater.from(holder.partnerIcon.context).inflate(R.drawable.girl_1, null, true) as ImageView
//        } else if(data[position].partnerId == 1) {
//            holder.partnerIcon = LayoutInflater.from(holder.partnerIcon.context).inflate(R.drawable.girl_2, null, true) as ImageView
//        } else if(data[position].partnerId == 2) {
//            holder.partnerIcon = LayoutInflater.from(holder.partnerIcon.context).inflate(R.drawable.girl_3, null, true) as ImageView
//        }

        Glide
                .with(holder.partnerIcon.context)
                .load("")
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.partnerIcon)

    }

    override fun getItemCount(): Int {
        return data.size
    }
}
