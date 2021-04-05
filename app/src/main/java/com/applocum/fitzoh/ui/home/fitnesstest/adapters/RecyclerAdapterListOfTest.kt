package com.applocum.fitzoh.ui.home.fitnesstest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.fitnesstest.models.ListOfTest
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_listoftest_xml.view.*

class RecyclerAdapterListOfTest(context: Context, list:ArrayList<ListOfTest>, private var cellClickListener: CellClickListener) :RecyclerView.Adapter<RecyclerAdapterListOfTest.TestHolder>(){
    var mContext=context
    var mList=list

    inner class TestHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_listoftest_xml,parent,false)
        return TestHolder(v)
    }

    override fun getItemCount(): Int {
    return mList.size
    }

    override fun onBindViewHolder(holder: TestHolder, position: Int) {
        val listoftest= mList[position]
        holder.itemView.tvName.text=listoftest.Listname
        holder.itemView.tvDescription.text=listoftest.Listdescription

        Glide.with(mContext).load(listoftest.Listimage).into(holder.itemView.ivTest)

        holder.itemView.setOnClickListener{
             cellClickListener.onCellClickistener(listoftest,position)
        }

    }
    interface CellClickListener
    {
         fun onCellClickistener(myobject: ListOfTest, position: Int)
    }
}