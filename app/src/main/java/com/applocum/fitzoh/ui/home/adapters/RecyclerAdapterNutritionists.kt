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
import com.applocum.fitzoh.ui.home.models.Counsellor
import com.applocum.fitzoh.ui.home.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_blog_xml.view.*

class RecyclerAdapterNutritionists(context: Context,list:ArrayList<Counsellor>):RecyclerView.Adapter<RecyclerAdapterNutritionists.NutritionHolder>() {
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
       val counsellor=mList.get(position)

        holder.itemView.tvLevel.text=counsellor.counsellorname
        holder.itemView.tvDescription.text=counsellor.counsellorexperience
        Glide.with(mContext).load(counsellor.counsellorimage).into(holder.itemView.ivLevel)

        holder.itemView.cvBlog.setOnClickListener {
            val intent=Intent(mContext,CounsellorActivity::class.java)
            intent.putExtra("counsellor",counsellor)
            intent.putExtra("position",position)
            mContext.startActivity(intent)
        }
    }
}