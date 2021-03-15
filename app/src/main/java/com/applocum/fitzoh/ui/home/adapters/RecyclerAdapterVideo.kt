package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Categories
import com.applocum.fitzoh.ui.home.models.Video
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_video_xml.view.*

class RecyclerAdapterVideo(context: Context,list:ArrayList<Categories>):RecyclerView.Adapter<RecyclerAdapterVideo.VideoHolder>() {
    var mContext=context
    var mList=list

    inner class VideoHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_video_xml,parent,false)
        return VideoHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        val video=mList.get(position)

       holder.itemView.tvTitle.text=video.cDescription
        holder.itemView.videoview.setVideoURI(Uri.parse("android.resource://" + mContext.packageName + "/" + video.cVideo))
        holder.itemView.videoview.start()
    }
}