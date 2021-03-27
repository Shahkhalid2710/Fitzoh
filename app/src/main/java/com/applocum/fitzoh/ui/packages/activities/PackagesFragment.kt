package com.applocum.fitzoh.ui.packages.activities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.HolisticHealthTransferActivity
import kotlinx.android.synthetic.main.fragment_packages.view.*


class PackagesFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v = inflater.inflate(R.layout.fragment_packages, container, false)

        v.ivanomika.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivonlinetraining.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivOnlineCounsellor.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivStrength.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivYoga.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivMeditation.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.ivedurance.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.cvmealpackage.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }
        v.cvConsultations.setOnClickListener {
            val intent= Intent(activity,
                HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }





        return v
    }
}