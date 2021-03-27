package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.raw_xml_time.view.*


class RecyclerAdapterSlotBookingTime(context: Context, list:ArrayList<String>, private var cellClickListener:CellClickListener):RecyclerView.Adapter<RecyclerAdapterSlotBookingTime.SlotBookingHolder>() {
    var mContext=context
    var mList=list
    private var selectedItem:Int=0

    inner class SlotBookingHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SlotBookingHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_time,parent,false)
        return SlotBookingHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: SlotBookingHolder, position: Int) {
        val time= mList[position]
        holder.itemView.tvTime.text=time


        holder.itemView.setOnClickListener {
            selectedItem = position
            notifyDataSetChanged()
            cellClickListener.onCellClickistener(time,position)

        }
            if (selectedItem == holder.adapterPosition) {
                holder.itemView.ll.setBackgroundColor(Color.parseColor("#3AD1BE"))
                holder.itemView.tvTime.setTextColor(Color.parseColor("#FFFFFFFF"))
            }
           /* else {
               // holder.itemView.ll.setBackgroundColor(Color.parseColor("#FFFFFFFF"))
                holder.itemView.tvTime.setTextColor(Color.parseColor("#333333"))
            }*/

    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: String, position: Int)
    }

}