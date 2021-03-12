package com.applocum.fitzoh.ui.home.activities

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.models.Slotbooking
import kotlinx.android.synthetic.main.fragment_slot_booking.view.*

class SlotBookingFragment : Fragment() {
    private var mList:ArrayList<Slotbooking> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_slot_booking, container, false)

        val slotbooking1= Slotbooking(
            "12pm - 03pm",
            "12:00",
            "12:30",
            "01:00",
            "01:30",
            "02:00",
            "02:30"
        )
        val slotbooking2= Slotbooking(
            "06pm-09pm",
            "06:00",
            "06:30",
            "07:00",
            "07:30",
            "08:00",
            "08:30"
        )

       mList.add(slotbooking1)
       mList.add(slotbooking2)

        v.rv.layoutManager=LinearLayoutManager(activity)
        v.rv.adapter= activity?.let {
            RecyclerAdapterSlotBookingTime(
                it,
                mList
            )
        }
        return v
    }
}