package com.applocum.fitzoh

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_fitnessplan_xml.view.*

class RecyclerAdapterfitnessplan(context: Context,list:ArrayList<Fitnessplan>):RecyclerView.Adapter<RecyclerAdapterfitnessplan.Fitholder>() {
    private var mcontext =context
    var mlist=list

    inner class Fitholder(itemview:View):RecyclerView.ViewHolder(itemview) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Fitholder {
        val v=LayoutInflater.from(mcontext).inflate(R.layout.raw_fitnessplan_xml,parent,false)
        return Fitholder(v)
    }

    override fun getItemCount(): Int {
        return mlist.size
    }

    override fun onBindViewHolder(holder: Fitholder, position: Int) {
        val fitnessplan= mlist[position]
        holder.itemView.tvplanName.text=fitnessplan.planname
        holder.itemView.tvRound.text=fitnessplan.planround


        Glide.with(mcontext).load(fitnessplan.planImage).into(holder.itemView.ivFitnessplan)

    }

}