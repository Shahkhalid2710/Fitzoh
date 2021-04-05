package com.applocum.fitzoh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.ui.home.trainer.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_request_xml.view.*

class RecyclerAdapterSessionRequest(context: Context,list:ArrayList<Trainer>):RecyclerView.Adapter<RecyclerAdapterSessionRequest.SessionRequestHolder>(){

    private var mcontext=context
    var mlist=list

    inner class SessionRequestHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SessionRequestHolder {
        val view=LayoutInflater.from(mcontext).inflate(R.layout.raw_request_xml,parent,false)
        return SessionRequestHolder(view)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: SessionRequestHolder, position: Int) {
        val trainer= mlist[position]
        holder.itemView.tvBewell.text=trainer.trainername
        Glide.with(mcontext).load(trainer.trainerimage).into(holder.itemView.ivBewell)
    }
}