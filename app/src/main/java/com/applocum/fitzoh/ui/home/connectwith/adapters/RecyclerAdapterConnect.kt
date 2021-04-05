package com.applocum.fitzoh.ui.home.connectwith.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.connectwith.models.ConnectWith
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_connectwith_xml.view.*

class RecyclerAdapterConnect(context: Context,list:ArrayList<ConnectWith>):RecyclerView.Adapter<RecyclerAdapterConnect.ConnectHolder>() {
    private var mContext=context
    private var mList=list

    inner class ConnectHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConnectHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_connectwith_xml,parent,false)
        return ConnectHolder(v)
    }
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ConnectHolder, position: Int) {
        val connectWith= mList[position]

        holder.itemView.tvName.text=connectWith.connectName
        holder.itemView.tvDescription.text=connectWith.connectDescription
        holder.itemView.tvSearch.text=connectWith.connextSearch
        Glide.with(mContext).load(connectWith.connectImage).into(holder.itemView.ivConnect)
    }
}