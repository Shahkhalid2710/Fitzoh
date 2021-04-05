package com.applocum.fitzoh.ui.home.wholestichealthandwellness.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.counsellor.models.Counsellor
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_blog_xml.view.*

class RecyclerAdapterNutritionists(context: Context, list:ArrayList<Counsellor>, private var cellClickListener: CellClickListener):RecyclerView.Adapter<RecyclerAdapterNutritionists.NutritionHolder>() {
    var mContext=context
   private var mList=list

    inner class NutritionHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_blog_xml,parent,false)
        return NutritionHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NutritionHolder, position: Int) {
       val counsellor= mList[position]

        holder.itemView.tvLevel.text=counsellor.counsellorname
        holder.itemView.tvDescription.text=counsellor.counsellorexperience
        Glide.with(mContext).load(counsellor.counsellorimage).into(holder.itemView.ivLevel)

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickistener(counsellor,position)
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Counsellor, position: Int)
    }
}