package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Fitzohvideo
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_fitzohvideo_xml.view.*

class RecyclerAdapterVideoLibrary(context: Context,list:ArrayList<Fitzohvideo>):RecyclerView.Adapter<RecyclerAdapterVideoLibrary.VideolibraryHolder>(){
    private var mContext=context
    private var mList=list

    inner class VideolibraryHolder(itemview:View):RecyclerView.ViewHolder(itemview){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideolibraryHolder {
     val v=LayoutInflater.from(mContext).inflate(R.layout.raw_fitzohvideo_xml,parent,false)
        return VideolibraryHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: VideolibraryHolder, position: Int) {

        val fitzohvideo= mList[position]
        holder.itemView.tvEveryday.text=fitzohvideo.fname
        holder.itemView.tvDescription.text=fitzohvideo.fdescription

       Glide.with(mContext).load(fitzohvideo.fimage).into(holder.itemView.ivVideoLibrary)


    }
}