package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Packages
import kotlinx.android.synthetic.main.raw_xml_basicpackages.view.*

class RecyclerAdapterBasicPackages(context: Context,list:ArrayList<Packages>,private var cellClickListener:CellClickListener) :RecyclerView.Adapter<RecyclerAdapterBasicPackages.BasicPackageHolder>(){
    var mContext=context
    var mList:ArrayList<Packages> =list

    inner class BasicPackageHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicPackageHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_basicpackages,parent,false)
        return BasicPackageHolder(v)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    override fun onBindViewHolder(holder: BasicPackageHolder, position: Int) {
        val packages= mList[position]

        holder.itemView.tvPayMonth.text=packages.bName
        holder.itemView.tvPrice.text=packages.bPrice

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickistener(packages,position)
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Packages, position: Int)
    }
}