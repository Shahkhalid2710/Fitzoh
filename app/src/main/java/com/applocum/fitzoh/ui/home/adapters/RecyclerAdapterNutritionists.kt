package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.CounsellorActivity
import com.applocum.fitzoh.ui.home.models.Blog
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_blog_xml.view.*

class RecyclerAdapterNutritionists(context: Context,list:ArrayList<Blog>):RecyclerView.Adapter<RecyclerAdapterNutritionists.NutritionHolder>() {
    var mContext=context
    var mList=list

    inner class NutritionHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_blog_xml,parent,false)
        return NutritionHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: NutritionHolder, position: Int) {
       val blog=mList.get(position)
        holder.itemView.tvLevel.text=blog.bLevel
        holder.itemView.tvDescription.text=blog.bDescription

        holder.itemView.ivNext.setOnClickListener {
            val intent=Intent(mContext,CounsellorActivity::class.java)
            mContext.startActivity(intent)
        }

        Glide.with(mContext).load(blog.bImage).into(holder.itemView.ivLevel)
    }
}