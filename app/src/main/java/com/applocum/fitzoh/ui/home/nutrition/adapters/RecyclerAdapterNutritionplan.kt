package com.applocum.fitzoh.ui.home.nutrition.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.nutrition.activities.AddFoodItemActivity
import com.applocum.fitzoh.ui.home.nutrition.models.NutritionMeal
import kotlinx.android.synthetic.main.raw_nutritionplan_xml.view.*

class RecyclerAdapterNutritionplan(context: Context, list: ArrayList<NutritionMeal>, private var cellClickListener: CellClickListener) :
    RecyclerView.Adapter<RecyclerAdapterNutritionplan.NutritionPlanHolder>() {
    var mContext = context
    private var mList = list

    inner class NutritionPlanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionPlanHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.raw_nutritionplan_xml, parent, false)
        return NutritionPlanHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NutritionPlanHolder, position: Int) {
        val nutritionMeal = mList[position]
        holder.itemView.tvMealName.text = nutritionMeal.nName
        holder.itemView.tvMealTime.text = nutritionMeal.nTime
        holder.itemView.tvNoofserving.text = nutritionMeal.nNoofserving
        holder.itemView.tvtotalpiece.text = nutritionMeal.nServingsize
        holder.itemView.tvFoodname.text = nutritionMeal.nFood
        holder.itemView.ivAdd.setOnClickListener {
            val intent = Intent(mContext, AddFoodItemActivity::class.java)
            intent.putExtra("nutritionMeal", nutritionMeal)
            intent.putExtra("position", position)
            mContext.startActivity(intent)
        }
        holder.itemView.ivList.setOnClickListener {
            holder.itemView.llCalories.visibility = View.VISIBLE
        }
        holder.itemView.ivDelete.setOnClickListener {
            cellClickListener.onCellClickistener(nutritionMeal,position)
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: NutritionMeal, position: Int)
    }
}