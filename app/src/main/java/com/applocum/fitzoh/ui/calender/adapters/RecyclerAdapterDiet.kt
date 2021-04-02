package com.applocum.fitzoh.ui.calender.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.calender.models.Diet
import kotlinx.android.synthetic.main.raw_diet_xml.view.*

class RecyclerAdapterDiet(context: Context,list:ArrayList<Diet>,private var cellClickListener:CellClickListener):RecyclerView.Adapter<RecyclerAdapterDiet.DietHolder>(){
    var mContext=context
    var mList=list

    inner class DietHolder(itemview:View):RecyclerView.ViewHolder(itemview){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_diet_xml,parent,false)
        return DietHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: DietHolder, position: Int) {
        val diet=mList[position]
        holder.itemView.tvitem1.text=diet.dItem1
        holder.itemView.tvitem2.text=diet.dItem2
        holder.itemView.tvno1.text=diet.dNo1
        holder.itemView.tvno2.text=diet.dNo2
        holder.itemView.tvtimename.text=diet.dTimename
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickistener(diet,position)
        }

    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Diet, position: Int)
    }
}