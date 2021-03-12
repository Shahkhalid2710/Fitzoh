package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.NutritionPlan
import kotlinx.android.synthetic.main.raw_nutritionplan_xml.view.*

class RecyclerAdapterNutritionplan(context: Context,list: ArrayList<NutritionPlan>):RecyclerView.Adapter<RecyclerAdapterNutritionplan.NutritionPlanHolder>() {
    var mContext=context
    var mList=list

    inner class NutritionPlanHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionPlanHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_nutritionplan_xml,parent,false)
        return NutritionPlanHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NutritionPlanHolder, position: Int) {
        val nutritionplan=mList.get(position)
        holder.itemView.tvTime.text=nutritionplan.nTime
        holder.itemView.tvCalories.text=nutritionplan.nCalories

    }

}