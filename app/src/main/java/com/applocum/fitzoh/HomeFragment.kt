package com.applocum.fitzoh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.ui.home.models.SessionRequest
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {
    private var mList: ArrayList<SessionRequest> = ArrayList()
    private var mList2: ArrayList<UpcomingRequest> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val sessionRequest1 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        val sessionRequest2 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        val sessionRequest3 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        val sessionRequest4 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        val sessionRequest5 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        val sessionRequest6 = SessionRequest(
            R.drawable.bewell,
            "Bewell B."
        )
        mList.add(sessionRequest1)
        mList.add(sessionRequest2)
        mList.add(sessionRequest3)
        mList.add(sessionRequest4)
        mList.add(sessionRequest5)
        mList.add(sessionRequest6)


        val upcomingRequest1=UpcomingRequest(R.drawable.bewell,"Bewell Bykelly","Yoga","12/06/2020 | 14: 00pm")
        val upcomingRequest2=UpcomingRequest(R.drawable.ena,"Enaa blatner","Fitness","12/06/2020 | 14: 00pm")
        val upcomingRequest3=UpcomingRequest(R.drawable.bewell,"Bewell Bykelly","Yoga","12/06/2020 | 14: 00pm")
        val upcomingRequest4=UpcomingRequest(R.drawable.ena,"Enaa blatner","Fitness","12/06/2020 | 14: 00pm")

        mList2.add(upcomingRequest1)
        mList2.add(upcomingRequest2)
        mList2.add(upcomingRequest3)
        mList2.add(upcomingRequest4)

        val v=inflater.inflate(R.layout.fragment_home, container, false)

        v.rvRequest.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        v.rvRequest.adapter = activity?.let { RecyclerAdapterUpcomingRequest(it, mList2) }

        v.recyclerview.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        v.recyclerview.adapter = activity?.let { RecyclerAdapterSessionRequest(it, mList) }
      return v
    }

}
