package com.applocum.fitzoh.ui.calender.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.calender.models.Exercise
import com.applocum.fitzoh.ui.home.workout.activities.CheckWorkOutActivity
import kotlinx.android.synthetic.main.raw_exercise_xml.view.*

class RecyclerAdapterExercise(context: Context,list:ArrayList<Exercise>,private var cellClickListener:CellClickListener) :RecyclerView.Adapter<RecyclerAdapterExercise.ExerciseHolder>(){
    var mContext=context
    var mList=list

    inner class ExerciseHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseHolder {
        val v=LayoutInflater.from(mContext).inflate(R.layout.raw_exercise_xml,parent,false)
        return ExerciseHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ExerciseHolder, position: Int) {
        val exercise=mList[position]
        holder.itemView.tvsetno.text=exercise.eSetno
        holder.itemView.tvexerciseno.text=exercise.eExerciseno
        holder.itemView.setOnClickListener{
            cellClickListener.onCellClickistener(exercise,position)
        }
        holder.itemView.btnStart.setOnClickListener {
            val intent=Intent(mContext,
                CheckWorkOutActivity::class.java)
            mContext.startActivity(intent)
        }

    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Exercise, position: Int)
    }
}