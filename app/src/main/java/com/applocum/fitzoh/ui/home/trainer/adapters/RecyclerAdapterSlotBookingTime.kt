package com.applocum.fitzoh.ui.home.trainer.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.raw_xml_time.view.*


class RecyclerAdapterSlotBookingTime(context: Context, list:ArrayList<String>, private var cellClickListener: CellClickListener):RecyclerView.Adapter<RecyclerAdapterSlotBookingTime.SlotBookingHolder>() {
    var mContext=context
    var mList=list
    private var selectedItem:Int=-1

    inner class SlotBookingHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotBookingHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_time,parent,false)
        return SlotBookingHolder(v)
    }
    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: SlotBookingHolder, position: Int) {
        val slotbooking= mList.get(position)
        holder.itemView.tvTime.text= slotbooking
        holder.itemView.setOnClickListener {
            selectedItem =position
            notifyDataSetChanged()
            cellClickListener.onCellClickistener(slotbooking,position)

        }
            if (selectedItem == holder.adapterPosition) {
                holder.itemView.ll.setBackgroundColor(Color.parseColor("#3AD1BE"))
                holder.itemView.tvTime.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: String, position: Int)
    }
}