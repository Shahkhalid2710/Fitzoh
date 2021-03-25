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
import com.applocum.fitzoh.ui.home.models.Workout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_xml.*
import kotlinx.android.synthetic.main.raw_xml_workout.view.*

class RecyclerAdapterWorkout(context: Context,list: ArrayList<Workout>,var cellClickListener: RecyclerAdapterWorkout.CellClickListener):RecyclerView.Adapter<RecyclerAdapterWorkout.WorkoutHolder>() {
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
        holder.itemView.cbSelect.tag= mList[position]

        holder.itemView.ivWorkout.setOnClickListener {
            val metrics: DisplayMetrics = mContext.getResources().getDisplayMetrics()

            val DeviceTotalWidth = metrics.widthPixels
            val DeviceTotalHeight = metrics.heightPixels

            val dialog = Dialog(mContext)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_xml)
            dialog.window!!.setLayout(DeviceTotalWidth, DeviceTotalHeight)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.videoview.setVideoURI(Uri.parse(workout.wVideo))
            dialog.videoview.start()

            dialog.ivCancel.setOnClickListener {
                dialog.cancel()
            }

            dialog.show()
        }
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickistener(workout,position)
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Workout, position: Int)
    }
}