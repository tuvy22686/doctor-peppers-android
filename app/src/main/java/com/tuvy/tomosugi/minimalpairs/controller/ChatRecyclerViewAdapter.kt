package com.tuvy.tomosugi.minimalpairs.controller

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
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
        holder.messageView.text = data[position].message
        holder.partnerName.text = data[position].partnerName

        Glide
                .with(holder.partnerIcon.context)
                .load("")
                .placeholder(R.drawable.hamutaro)
                .into(holder.partnerIcon)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
