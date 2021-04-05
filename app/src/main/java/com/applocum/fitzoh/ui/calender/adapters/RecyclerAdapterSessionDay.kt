package com.applocum.fitzoh.ui.calender.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.calender.models.SessionDay
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_sessionday_xml.view.*

class RecyclerAdapterSessionDay(context: Context,list:ArrayList<SessionDay>,private var cellClickListener:CellClickListener):RecyclerView.Adapter<RecyclerAdapterSessionDay.SessionHolder>(){
    var mContext=context
    var mList=list

    inner class SessionHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_sessionday_xml,parent,false)
        return SessionHolder(v)
    }
    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: SessionHolder, position: Int) {
        val sessionDay=mList[position]
        holder.itemView.tvSessionName.text=sessionDay.sSessionname
        holder.itemView.tvSessionTitle.text=sessionDay.sSessiontilte
        holder.itemView.tvTrainername.text=sessionDay.sTrainername
        holder.itemView.tvTime1.text=sessionDay.sTime1
        holder.itemView.tvTime2.text=sessionDay.sTime2
        holder.itemView.tvTime3.text=sessionDay.sTime3

        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickistener(sessionDay,position)
        }

        Glide.with(mContext).load(sessionDay.simage).into(holder.itemView.ivSession)
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: SessionDay, position: Int)
    }
}