package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.SessionCategory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_sessiontype_xml.view.*
import kotlinx.android.synthetic.main.raw_xml_workout.view.*

class RecyclerAdapterSession(context: Context, list: ArrayList<SessionCategory>, private var cellClickListener:CellClickListener) :RecyclerView.Adapter<RecyclerAdapterSession.SessionHolder>(){

    var mContext=context
    var mList=list
    var  selectedPosition = -1

    inner class SessionHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolder {
      val v=LayoutInflater.from(mContext).inflate(R.layout.raw_sessiontype_xml,parent,false)
        return SessionHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: SessionHolder, position: Int) {
       val session= mList[position]
        holder.itemView.tvTitle.text=session.sName
        holder.itemView.cbSession.tag= mList[position]
        Glide.with(mContext).load(session.sImage).into(holder.itemView.ivType)

        holder.itemView.llsession.setOnClickListener {
           // holder.itemView.cbSession.isChecked=true
            selectedPosition=position
            Log.d("posiiiiiion","-->"+selectedPosition)
            cellClickListener.onCellClickistener(session,position)

            notifyDataSetChanged()
        }

        if (selectedPosition == position)
        {
            session.sStatus=1
            holder.itemView.cbSession.isChecked=true
        }
        else
        {
            session.sStatus=0
            holder.itemView.cbSession.isChecked=false
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: SessionCategory, position: Int)
    }
    }
