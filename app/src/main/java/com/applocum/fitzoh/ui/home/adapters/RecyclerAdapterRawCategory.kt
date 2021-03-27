package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.EveryDayBllishActivity
import com.applocum.fitzoh.ui.home.models.CategoryRaw
import kotlinx.android.synthetic.main.raw_xml_library.view.*


class RecyclerAdapterRawCategory(context: Context,list:ArrayList<CategoryRaw>) :RecyclerView.Adapter<RecyclerAdapterRawCategory.CategoriesHolder>(){
    var mContext=context
   var mList=list

    inner class CategoriesHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_library,parent,false)
        return CategoriesHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
         val categoryRaw= mList[position]

        holder.itemView.rvRaw.layoutManager= LinearLayoutManager(mContext,LinearLayoutManager.HORIZONTAL,false)
        holder.itemView.rvRaw.adapter=RecyclerAdapterCategories(mContext,categoryRaw.mylist)

        Log.d("callled","-"+categoryRaw.cName)

        holder.itemView.tvCategoryname.text=categoryRaw.cName


        holder.itemView.tvViewmoreCategory.setOnClickListener {
           val intent=Intent(mContext,EveryDayBllishActivity::class.java)
           intent.putExtra("categories",categoryRaw)
           intent.putExtra("position",position)
           mContext.startActivity(intent)
       }
    }

}