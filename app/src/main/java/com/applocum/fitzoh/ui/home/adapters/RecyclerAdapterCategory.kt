package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Category
import kotlinx.android.synthetic.main.raw_fitzohlibrary_xml.view.*
import kotlinx.android.synthetic.main.raw_nutritionplan_xml.view.*

class RecyclerAdapterCategory(context: Context,list: ArrayList<Category>) :RecyclerView.Adapter<RecyclerAdapterCategory.CategoryHolder>(){
    var mContext=context
    var mList=list

    inner class CategoryHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_fitzohlibrary_xml,parent,false)
        return CategoryHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
        val category=mList.get(position)
        holder.itemView.tvCategories.text=category.cName

    }
}