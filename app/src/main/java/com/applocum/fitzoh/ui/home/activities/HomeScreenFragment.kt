package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.*
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterBlog
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterConnect
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterVideoLibrary
import com.applocum.fitzoh.ui.home.models.Blog
import com.applocum.fitzoh.ui.home.models.ConnectWith
import com.applocum.fitzoh.ui.home.models.Fitzohvideo
import kotlinx.android.synthetic.main.fragment_home_screen.view.*


class HomeScreenFragment : Fragment() {
    private var mList:ArrayList<ConnectWith> = ArrayList()
    private var mList3:ArrayList<Fitzohvideo> = ArrayList()
    private var mList4:ArrayList<Blog> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_home_screen, container, false)

        val connectWith1= ConnectWith(
            R.drawable.image_connect,
            "CONNECT WITH",
            "The Best Online Trainers andArchieve your fitness goals",
            "SEARCH"
        )
        val connectWith2= ConnectWith(
            R.drawable.image_connect,
            "CONNECT WITH",
            "The Best Online Trainers andArchieve your fitness goals",
            "SEARCH"
        )
        val connectWith3= ConnectWith(
            R.drawable.image_connect,
            "CONNECT WITH",
            "The Best Online Trainers andArchieve your fitness goals",
            "SEARCH"
        )

        mList.add(connectWith1)
        mList.add(connectWith2)
        mList.add(connectWith3)

        v.rvConnectwith.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL,false)
        v.rvConnectwith.adapter= activity?.let {
            RecyclerAdapterConnect(
                it,
                mList
            )
        }

        val fitzohvideo1= Fitzohvideo(
            R.drawable.image_videolibrary,
            "EVERY DAY BLISH",
            "Hypnosis for instant Freedom from stress & Anxiety"
        )
        val fitzohvideo2= Fitzohvideo(
            R.drawable.image_videolibrary,
            "EVERY DAY BLISH",
            "Hypnosis for instant Freedom from stress & Anxiety"
        )
        val fitzohvideo3= Fitzohvideo(
            R.drawable.image_videolibrary,
            "EVERY DAY BLISH",
            "Hypnosis for instant Freedom from stress & Anxiety"
        )
        val fitzohvideo4= Fitzohvideo(
            R.drawable.image_videolibrary,
            "EVERY DAY BLISH",
            "Hypnosis for instant Freedom from stress & Anxiety"
        )

        mList3.add(fitzohvideo1)
        mList3.add(fitzohvideo2)
        mList3.add(fitzohvideo3)
        mList3.add(fitzohvideo4)

        v.rvFitzohvideo.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        v.rvFitzohvideo.adapter= activity?.let {
            RecyclerAdapterVideoLibrary(
                it,
                mList3
            )
        }

        val blog1= Blog(
            R.drawable.img_beginner,
            "Beginners",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae pellentesque lacus, sagittis interdum…"
        )
        val blog2= Blog(
            R.drawable.img_intermedeter,
            "Intermediate",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque vitae pellentesque lacus, sagittis interdum…"
        )

        mList4.add(blog1)
        mList4.add(blog2)

        v.rvBlog.layoutManager=LinearLayoutManager(activity)
        v.rvBlog.adapter= activity?.let {
            RecyclerAdapterBlog(
                it,
                mList4
            )
        }

        v.cvUpcomingSessions.setOnClickListener {
            val intent=Intent(activity,
                StrengthSessionActivity::class.java)
            startActivity(intent)
        }
        v.cvTrainerProfile.setOnClickListener {
            val intent=Intent(activity,
                AboutTrainerActivity::class.java)
            startActivity(intent)
        }
        v.cvgeneralCounsellor.setOnClickListener {
            val intent=Intent(activity, CounsellorActivity::class.java)
            startActivity(intent)
        }
        v.ivFitnessTest.setOnClickListener {
            val intent=Intent(activity, ListOfTestActivity::class.java)
            startActivity(intent)
        }

        return v
    }
    }
