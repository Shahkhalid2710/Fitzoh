package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.NutritionistCounsellorsActivity
import com.applocum.fitzoh.ui.home.models.BasicPackages
import kotlinx.android.synthetic.main.raw_xml_basicpackages.view.*

class RecyclerAdapterBasicPackages(context: Context,list:ArrayList<BasicPackages>) :RecyclerView.Adapter<RecyclerAdapterBasicPackages.BasicPackageHolder>(){
    var mContext=context
    var mList=list

    inner class BasicPackageHolder(itemView: View):RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasicPackageHolder {
       val v=LayoutInflater.from(mContext).inflate(R.layout.raw_xml_basicpackages,parent,false)
        return BasicPackageHolder(v)
    }

    override fun getItemCount(): Int {
      return mList.size
    }

    override fun onBindViewHolder(holder: BasicPackageHolder, position: Int) {
        val basicPackages=mList.get(position)

        holder.itemView.tvPayMonth.text=basicPackages.bName
        holder.itemView.tvPrice.text=basicPackages.bPrice

        holder.itemView.cvBuy.setOnClickListener {
            val intent=Intent(mContext,NutritionistCounsellorsActivity::class.java)
            intent.putExtra("basicpackages",basicPackages)
            intent.putExtra("position",position)
            mContext.startActivity(intent)
        }
    }
}