package com.tuvy.tomosugi.minimalpairs.controller

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.tuvy.tomosugi.minimalpairs.ChatActivity
import com.tuvy.tomosugi.minimalpairs.R
import com.tuvy.tomosugi.minimalpairs.model.User
import com.tuvy.tomosugi.minimalpairs.view.PartnerViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


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

        //プロフィール取得用API(テスト)
        val client = MinimalPairsClient()

        if (position + 2 == 2) {
            client.getProfile2()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.d("getProfile", "doOnSubscribe")
                    }
                    .doOnError {
                        Log.d("getProfile", "doOnError")
                    }
                    .doOnNext {
                        Log.d("getProfile", "doOnNext")
                    }
                    .subscribe {
                        Log.d("getProfile", "subscribe")
                        holder as PartnerViewHolder
                        holder.partnerName.text = it.name
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", it.id)
                            context.startActivity(intent)
                        }
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", data[position].id)
                            context.startActivity(intent)
                        }

                        holder.partnerStatus.text = it.name + "さんとマッチングしました"
                        Glide
                                .with(holder.partnerIcon.context)
                                .load("")
                                .placeholder(R.drawable.girl_1)
                                .into(holder.partnerIcon)
                    }
        }
        else if (position + 2 == 3) {
            client.getProfile3()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.d("getProfile", "doOnSubscribe")
                    }
                    .doOnError {
                        Log.d("getProfile", "doOnError")
                    }
                    .doOnNext {
                        Log.d("getProfile", "doOnNext")
                    }
                    .subscribe {
                        Log.d("getProfile", "subscribe")
                        holder as PartnerViewHolder
                        holder.partnerName.text = it.name
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", it.id)
                            context.startActivity(intent)
                        }
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", data[position].id)
                            context.startActivity(intent)
                        }

                        holder.partnerStatus.text = it.name + "さんとマッチングしました"
                        Glide
                                .with(holder.partnerIcon.context)
                                .load("")
                                .placeholder(R.drawable.girl_2)
                                .into(holder.partnerIcon)
                    }
        }
        else if (position + 2 == 4) {
            client.getProfile4()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnSubscribe {
                        Log.d("getProfile", "doOnSubscribe")
                    }
                    .doOnError {
                        Log.d("getProfile", "doOnError")
                    }
                    .doOnNext {
                        Log.d("getProfile", "doOnNext")
                    }
                    .subscribe {
                        Log.d("getProfile", "subscribe")
                        holder as PartnerViewHolder
                        holder.partnerName.text = it.name
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", it.id)
                            context.startActivity(intent)
                        }
                        holder.layout.setOnClickListener {
                            val context = holder.partnerName.context
                            val intent = Intent(context, ChatActivity::class.java)
                            intent.putExtra("partnerId", data[position].id)
                            context.startActivity(intent)
                        }

                        holder.partnerStatus.text = it.name + "さんとマッチングしました"
                        Glide
                                .with(holder.partnerIcon.context)
                                .load("")
                                .placeholder(R.drawable.girl_3)
                                .into(holder.partnerIcon)
                    }
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
