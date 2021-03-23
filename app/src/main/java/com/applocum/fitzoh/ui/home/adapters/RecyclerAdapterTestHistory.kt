package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.FitnessTest
import com.applocum.fitzoh.ui.home.models.TestHistory
import kotlinx.android.synthetic.main.raw_testhistory_xml.view.*

class RecyclerAdapterTestHistory(context: Context,list:ArrayList<FitnessTest>):RecyclerView.Adapter<RecyclerAdapterTestHistory.TestHistoryHolder>() {

    var mContext=context
    var mList=list

    inner class TestHistoryHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestHistoryHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_testhistory_xml,parent,false)
        return TestHistoryHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: TestHistoryHolder, position: Int) {
        val fitnessTest=mList.get(position)
        holder.itemView.tvTime1.text=fitnessTest.fTime
        holder.itemView.tvResult1.text=fitnessTest.fResult
        holder.itemView.tvComment1.text=fitnessTest.fComment

    }
}