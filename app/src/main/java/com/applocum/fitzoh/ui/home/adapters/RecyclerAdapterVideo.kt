package com.applocum.fitzoh.ui.home.adapters

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Categories
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_xml.*
import kotlinx.android.synthetic.main.raw_video_xml.view.*

class RecyclerAdapterVideo(context: Context, list: ArrayList<Categories>) :
    RecyclerView.Adapter<RecyclerAdapterVideo.VideoHolder>() {
    var mContext = context
    var mList = list

    inner class VideoHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoHolder {
        val v = LayoutInflater.from(mContext).inflate(R.layout.raw_video_xml, parent, false)
        return VideoHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: VideoHolder, position: Int) {
        val video = mList[position]

        holder.itemView.tvTitle.text = video.cDescription
        Glide.with(mContext).load(video.cImage).into(holder.itemView.ivVideo)

        holder.itemView.setOnClickListener {
            val metrics: DisplayMetrics = mContext.resources.displayMetrics

            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(mContext)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_xml)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.videoview.setVideoURI(Uri.parse(video.cVideo))
            dialog.videoview.start()

            dialog.ivCancel.setOnClickListener {
                dialog.cancel()
            }

            dialog.show()

        }
    }
}