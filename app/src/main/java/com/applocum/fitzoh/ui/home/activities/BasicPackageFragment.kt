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
import com.applocum.fitzoh.ui.home.models.BasicPackages
import kotlinx.android.synthetic.main.fragment_basic_package.*
import kotlinx.android.synthetic.main.fragment_basic_package.view.*

class BasicPackageFragment : Fragment() {

    var mListPackages:ArrayList<BasicPackages> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_basic_package, container, false)
        val dbhelper= activity?.let { Dbhelper(it) }
        mListPackages=dbhelper!!.getbasicpackage()
        v.rvBasicpackage.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
        v.rvBasicpackage.adapter= activity?.let { RecyclerAdapterBasicPackages(it,mListPackages) }
        return v
    }
    }
