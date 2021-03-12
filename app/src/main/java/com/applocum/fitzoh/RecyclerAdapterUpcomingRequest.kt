package com.applocum.fitzoh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_upcoming_request.view.*

class RecyclerAdapterUpcomingRequest(context: Context,list: ArrayList<UpcomingRequest>):RecyclerView.Adapter<RecyclerAdapterUpcomingRequest.UpcomingRequestHolder>() {

    private var mcontext=context
    var mlist=list
    inner class UpcomingRequestHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingRequestHolder {
        val v=LayoutInflater.from(mcontext).inflate(R.layout.raw_upcoming_request,parent,false)
        return UpcomingRequestHolder(v)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: UpcomingRequestHolder, position: Int) {
        val upcomingRequest= mlist[position]
        holder.itemView.tvName.text=upcomingRequest.requestname
        holder.itemView.tvYoga.text=upcomingRequest.request
        holder.itemView.tvDate.text=upcomingRequest.requestdate
        Glide.with(mcontext).load(upcomingRequest.requestimage).into(holder.itemView.ivUpcomingRequest)
    }
}