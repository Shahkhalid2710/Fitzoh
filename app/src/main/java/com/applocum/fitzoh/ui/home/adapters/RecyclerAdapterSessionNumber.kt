package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Sessionnumber
import kotlinx.android.synthetic.main.raw_session_xml.view.*

class RecyclerAdapterSessionNumber(context: Context,list:ArrayList<Sessionnumber>):RecyclerView.Adapter<RecyclerAdapterSessionNumber.NumberHolder>(){
    var mContext=context
    var mList=list

    inner class NumberHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_session_xml,parent,false)
        return NumberHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        val sessionnumber= mList[position]
        holder.itemView.tvSessionnumber.text=sessionnumber.sName

    }

}