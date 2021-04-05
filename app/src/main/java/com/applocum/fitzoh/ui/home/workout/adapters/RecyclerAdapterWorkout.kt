package com.applocum.fitzoh.ui.home.workout.adapters

import android.app.Dialog
import android.content.Context
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.workout.models.Workout
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.custom_xml.ivCancel
import kotlinx.android.synthetic.main.custom_youtube_video.*
import kotlinx.android.synthetic.main.raw_xml_workout.view.*

class RecyclerAdapterWorkout(context: Context, list: ArrayList<Workout>, private var cellClickListener: CellClickListener):RecyclerView.Adapter<RecyclerAdapterWorkout.WorkoutHolder>() {
    var mContext=context
    var mList=list

    inner class WorkoutHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_workout,parent,false)
        return WorkoutHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: WorkoutHolder, position: Int) {
        val workout= mList[position]
        holder.itemView.tvWorkoutname.text=workout.wName
        holder.itemView.tvRounds.text=workout.wAbout
        Glide.with(mContext).load(workout.wImage).into(holder.itemView.ivWorkout)

        holder.itemView.ivWorkout.setOnClickListener {
            val metrics: DisplayMetrics = mContext.resources.displayMetrics

            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(mContext)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_youtube_video)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)
            dialog.youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(workout.wVideo, 0f)
                }
            })

            dialog.ivCancel.setOnClickListener {
                dialog.cancel()
            }

            dialog.show()
        }

        if (workout.wStatus == 1)
        {
            holder.itemView.cbSelect.isChecked=true
        }
        else{

            holder.itemView.cbSelect.isChecked=false
        }

        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickistener(workout,position)
        }

        holder.itemView.cbSelect.setOnCheckedChangeListener { _, b ->
            if (b) {
                workout.wStatus=1
            } else {
                workout.wStatus=0
            }
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Workout, position: Int)
    }
}