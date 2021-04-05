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
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.ivonlinetraining.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.ivOnlineCounsellor.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }
        v.ivStrength.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.ivYoga.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.ivMeditation.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.ivedurance.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        v.cvmealpackage.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }
        v.cvConsultations.setOnClickListener {
            startActivity(Intent(activity,HolisticHealthTransferActivity::class.java))
        }

        return v
    }
}