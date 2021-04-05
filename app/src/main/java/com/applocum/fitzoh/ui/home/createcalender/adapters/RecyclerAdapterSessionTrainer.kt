package com.applocum.fitzoh.ui.home.createcalender.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.trainer.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.raw_trainertype_xml.view.*

class RecyclerAdapterSessionTrainer(context: Context, list: ArrayList<Trainer>, private var cellClickListener: CellClickListener):RecyclerView.Adapter<RecyclerAdapterSessionTrainer.TrainerHolder>() {
    var mContext=context
    var mList=list
    var selecttrainer=-1

    inner class TrainerHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainerHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_trainertype_xml,parent,false)
        return TrainerHolder(v)
    }

    override fun getItemCount(): Int {
       return mList.size
    }

    override fun onBindViewHolder(holder: TrainerHolder, position: Int) {
      val trainer= mList[position]

        holder.itemView.tvName.text=trainer.trainername
        holder.itemView.tvExperince.text=trainer.trainerexperince
        Glide.with(mContext).load(trainer.trainerimage).into(holder.itemView.ivPic)
        holder.itemView.setOnClickListener {
            holder.itemView.cb3.isChecked=true
            selecttrainer=trainer.id
            notifyDataSetChanged()
            cellClickListener.onCellClickistener(trainer,position)
        }
        if (selecttrainer == position)
        {
            trainer.trainerstatus=1
        }
        else
        {
            trainer.trainerstatus=0
        }
    }
    interface CellClickListener
    {
        fun onCellClickistener(myobject: Trainer, position: Int)
    }
}