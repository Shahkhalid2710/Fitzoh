package com.applocum.fitzoh.ui.home.fitzohvideolibrary.adapters

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.fitzohvideolibrary.models.Category
import kotlinx.android.synthetic.main.raw_fitzohlibrary_xml.view.*

class RecyclerAdapterCategory(context: Context, list: ArrayList<Category>, private var cellClickListener: CellClickListener) :RecyclerView.Adapter<RecyclerAdapterCategory.CategoryHolder>(){
    var mContext=context
    var mList=list
    private var selectedItem = 1

    inner class CategoryHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_fitzohlibrary_xml,parent,false)
        return CategoryHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category= mList[position]
       holder.itemView.tvCategories.text=category.cName

        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickistener(category,position)
            selectedItem = category.id
            notifyDataSetChanged()
        }
        if (selectedItem == category.id) {
            holder.itemView.llFitzoh.setBackgroundResource(R.drawable.btn_background)
            holder.itemView.tvCategories.setTextColor(Color.parseColor("#FFFFFFFF"))
        }
         else {
             holder.itemView.llFitzoh.setBackgroundResource(R.drawable.btn_default)
             holder.itemView.tvCategories.setTextColor(Color.parseColor("#3AD1BE"))
         }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Category, position: Int)
    }
}