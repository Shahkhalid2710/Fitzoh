package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Session
import com.applocum.fitzoh.ui.home.models.SessionTrainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_trainertype_xml.view.*

class RecyclerAdapterSessionTrainer(context: Context,list: ArrayList<SessionTrainer>):RecyclerView.Adapter<RecyclerAdapterSessionTrainer.TrainerHolder>() {
    var mContext=context
    var mList=list

    inner class TrainerHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainerHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_trainertype_xml,parent,false)
        return TrainerHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: TrainerHolder, position: Int) {
      val sessionTrainer=mList.get(position)

        holder.itemView.tvName.text=sessionTrainer.tName
        holder.itemView.tvExperince.text=sessionTrainer.tExp

        Glide.with(mContext).load(sessionTrainer.tImage).into(holder.itemView.ivPic)
    }

}