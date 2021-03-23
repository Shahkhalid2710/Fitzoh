package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.AddFoodItemActivity
import com.applocum.fitzoh.ui.home.models.NutritionMeal
import com.applocum.fitzoh.ui.home.models.NutritionPlan
import com.daimajia.swipe.SwipeLayout
import kotlinx.android.synthetic.main.raw_nutritionplan_xml.view.*

class RecyclerAdapterNutritionplan(context: Context,list: ArrayList<NutritionMeal>):RecyclerView.Adapter<RecyclerAdapterNutritionplan.NutritionPlanHolder>() {
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
        val nutritionMeal=mList.get(position)
        holder.itemView.tvMealName.text=nutritionMeal.nName
        holder.itemView.tvMealTime.text=nutritionMeal.nTime
        holder.itemView.ivAdd.setOnClickListener {
            val intent=Intent(mContext,AddFoodItemActivity::class.java)
            intent.putExtra("nutritionMeal",nutritionMeal)
            intent.putExtra("position",position)
            mContext.startActivity(intent)
        }

        holder.itemView.ivDelete.setOnClickListener {
            val dbhelper=Dbhelper(mContext)
            dbhelper.deletenutritionmeal(nutritionMeal.id)
            notifyItemChanged(holder.adapterPosition)
        }
    }
}