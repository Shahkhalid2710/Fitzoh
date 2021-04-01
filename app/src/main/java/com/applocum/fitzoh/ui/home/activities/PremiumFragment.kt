package com.applocum.fitzoh.ui.home.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterBasicPackages
import com.applocum.fitzoh.ui.home.models.Packages
import kotlinx.android.synthetic.main.fragment_premium.view.*

class PremiumFragment : Fragment() {
    private var mListPackages:ArrayList<Packages> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_premium, container, false)
         val dbhelper= activity?.let { Dbhelper(it) }
         mListPackages=dbhelper!!.getpremiumpackage()
         v.rvPremiumPackage.layoutManager=
             LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
         v.rvPremiumPackage.adapter= activity?.let { RecyclerAdapterBasicPackages(it,mListPackages,object :RecyclerAdapterBasicPackages.CellClickListener{
             override fun onCellClickistener(myobject: Packages, position: Int) {

             }
         }) }
        return v
    }
}
