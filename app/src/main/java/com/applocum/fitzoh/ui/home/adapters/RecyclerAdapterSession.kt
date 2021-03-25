package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Session
import com.applocum.fitzoh.ui.home.models.SessionCategory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_sessiontype_xml.view.*

class RecyclerAdapterSession(context: Context,list: ArrayList<SessionCategory>) :RecyclerView.Adapter<RecyclerAdapterSession.SessionHolder>(){

    var mContext=context
    var mList=list

    inner class SessionHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionHolder {
      val v=LayoutInflater.from(mContext).inflate(R.layout.raw_sessiontype_xml,parent,false)
        return SessionHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: SessionHolder, position: Int) {
       val session=mList.get(position)
        holder.itemView.tvTitle.text=session.sName
        holder.itemView.cbSession.tag=mList.get(position)
        Glide.with(mContext).load(session.sImage).into(holder.itemView.ivType)

        holder.itemView.ivType.setOnClickListener {
            holder.itemView.cbSession.isChecked=true
        }
    }
}