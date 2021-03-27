package com.applocum.fitzoh.ui.home.adapters

import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Categories
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.custom_xml.*
import kotlinx.android.synthetic.main.raw_xml_category.view.*


class RecyclerAdapterCategories(context: Context,list: ArrayList<Categories>) :RecyclerView.Adapter<RecyclerAdapterCategories.CategoriesHolder>(){
    var mContext=context
    var mList=list

    inner class CategoriesHolder(itemView:View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesHolder {
     val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_category,parent,false)
        return CategoriesHolder(v)
    }

    override fun getItemCount(): Int {
        return mList.size

    }

    override fun onBindViewHolder(holder: CategoriesHolder, position: Int) {
        val categories: Categories = mList[position]

        holder.itemView.tvDescription.text=categories.cDescription
        Glide.with(mContext).load(categories.cImage).into(holder.itemView.ivCategory)

        holder.itemView.setOnClickListener {
            val metrics = mContext.resources.displayMetrics
            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(mContext)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_xml)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.videoview.setVideoURI(Uri.parse(categories.cVideo))

            Log.d("myvideo","-->"+categories.cVideo)
            dialog.videoview.start()

            dialog.ivCancel.setOnClickListener {
                dialog.cancel()
            }

            dialog.show()

        }

    }

}