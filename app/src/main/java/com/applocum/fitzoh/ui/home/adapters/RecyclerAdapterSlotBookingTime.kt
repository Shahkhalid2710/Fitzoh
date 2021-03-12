package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Slotbooking
import kotlinx.android.synthetic.main.raw_xml_time.view.*

class RecyclerAdapterSlotBookingTime(context: Context,list:ArrayList<Slotbooking>):RecyclerView.Adapter<RecyclerAdapterSlotBookingTime.SlotBookingHolder>() {
    var mContext=context
    var mList=list

    inner class SlotBookingHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotBookingHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_time,parent,false)
        return SlotBookingHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: SlotBookingHolder, position: Int) {
        val slotbooking=mList.get(position)
        holder.itemView.tvBaseTime.text=slotbooking.baseTime
        holder.itemView.tvTime1.text=slotbooking.Time1
        holder.itemView.tvTime2.text=slotbooking.Time2
        holder.itemView.tvTime3.text=slotbooking.Time3
        holder.itemView.tvTime4.text=slotbooking.Time4
        holder.itemView.tvTime5.text=slotbooking.Time5
        holder.itemView.tvTime6.text=slotbooking.Time6

    }
}