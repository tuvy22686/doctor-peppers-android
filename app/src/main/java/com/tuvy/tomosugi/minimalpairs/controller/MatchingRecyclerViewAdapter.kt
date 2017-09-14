package com.tuvy.tomosugi.minimalpairs.controller

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tuvy.tomosugi.minimalpairs.ChatActivity
import com.tuvy.tomosugi.minimalpairs.R
import com.tuvy.tomosugi.minimalpairs.model.User
import com.tuvy.tomosugi.minimalpairs.view.PartnerViewHolder



class MatchingRecyclerViewAdapter(private val data: List<User>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.partner, parent, false)
        return PartnerViewHolder(inflate)
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        holder as PartnerViewHolder
        holder.partnerName.text = "User: " + data[position].id.toString()
        holder.layout.setOnClickListener {
            val context = holder.partnerName.context
            val intent = Intent(context, ChatActivity::class.java)
            intent.putExtra("partnerId", data[position].id)
            context.startActivity(intent)
        }

        if (position == 0) {
            holder.partnerName.text = "yuka"
            holder.partnerStatus.text = "yukaさんとマッチングしました"
            Glide
                    .with(holder.partnerIcon.context)
                    .load("")
                    .placeholder(R.drawable.girl_1)
                    .into(holder.partnerIcon)
        }
        else if (position == 1) {
            holder.partnerName.text = "aki"
            holder.partnerStatus.text = "akiさんとマッチングしました"
            Glide
                    .with(holder.partnerIcon.context)
                    .load("")
                    .placeholder(R.drawable.girl_2)
                    .into(holder.partnerIcon)
        }
        else {
            holder.partnerName.text = "sayuri"
            holder.partnerStatus.text = "sayuriさんとマッチングしました"
            Glide
                    .with(holder.partnerIcon.context)
                    .load("")
                    .placeholder(R.drawable.girl_3)
                    .into(holder.partnerIcon)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
