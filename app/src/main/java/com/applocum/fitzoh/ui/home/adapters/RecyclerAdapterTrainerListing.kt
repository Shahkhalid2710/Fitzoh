package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.AboutTrainerActivity
import com.applocum.fitzoh.ui.home.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_blog_xml.view.*

class RecyclerAdapterTrainerListing(context: Context,list: ArrayList<Trainer>):RecyclerView.Adapter<RecyclerAdapterTrainerListing.ListHolder>() {
    var mContext=context
    var mList=list

    inner class ListHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHolder {
        val v= LayoutInflater.from(mContext).inflate(R.layout.raw_blog_xml,parent,false)
        return ListHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ListHolder, position: Int) {
        val trainer= mList[position]
        holder.itemView.tvLevel.text=trainer.trainername
        holder.itemView.tvDescription.text=trainer.trainerexperince

        holder.itemView.cvBlog.setOnClickListener {
            val intent= Intent(mContext,AboutTrainerActivity::class.java)
            intent.putExtra("trainer",trainer)
            intent.putExtra("position",position)
            mContext.startActivity(intent)
        }

        Glide.with(mContext).load(trainer.trainerimage).into(holder.itemView.ivLevel)
    }

}