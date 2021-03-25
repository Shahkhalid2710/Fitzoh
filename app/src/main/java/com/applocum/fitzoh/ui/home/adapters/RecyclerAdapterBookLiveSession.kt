package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.LiveSessionActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_sessiontype_xml.view.*

class RecyclerAdapterBookLiveSession(
    context: Context,
    list: ArrayList<com.applocum.fitzoh.ui.home.models.Session>
):RecyclerView.Adapter<RecyclerAdapterBookLiveSession.BookliveSessionHolder>() {
    var mContext=context
    var mList=list

    inner class BookliveSessionHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookliveSessionHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_sessiontype_xml,parent,false)
        return BookliveSessionHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BookliveSessionHolder, position: Int) {
       val session= mList[position]
        holder.itemView.tvTitle.text=session.sTitle
        holder.itemView.cbSession.visibility=View.GONE

        holder.itemView.setOnClickListener {
            val intent=Intent(mContext,LiveSessionActivity::class.java)
            mContext.startActivity(intent)
        }
        Glide.with(mContext).load(session.sImage).into(holder.itemView.ivType)
    }
}