package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.TestHistory
import kotlinx.android.synthetic.main.raw_testhistory_xml.view.*

class RecyclerAdapterTestHistory(context: Context,list:ArrayList<TestHistory>):RecyclerView.Adapter<RecyclerAdapterTestHistory.TestHistoryHolder>() {

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
        val testHistory=mList.get(position)

        holder.itemView.tvDay.text=testHistory.tDay
        holder.itemView.tvDate.text=testHistory.tdate

        holder.itemView.tvTime1.text=testHistory.tTime1
        holder.itemView.tvTime2.text=testHistory.tTime2
        holder.itemView.tvTime3.text=testHistory.tTime3

        holder.itemView.tvResult1.text=testHistory.tResult1
        holder.itemView.tvResult2.text=testHistory.tResult2
        holder.itemView.tvResult3.text=testHistory.tResult3

        holder.itemView.tvComment1.text=testHistory.tComment1
        holder.itemView.tvComment2.text=testHistory.tComment2
        holder.itemView.tvComment3.text=testHistory.tComment3

    }
}