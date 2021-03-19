package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.*
import com.applocum.fitzoh.ui.home.adapters.*
import com.applocum.fitzoh.ui.home.models.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_home_screen.view.*
import kotlinx.android.synthetic.main.fragment_home_screen.view.cvUpcomingSessions


class HomeScreenFragment : Fragment() {
    private var mList:ArrayList<ConnectWith> = ArrayList()
    private var mList3:ArrayList<Fitzohvideo> = ArrayList()
    private var mListBlog:ArrayList<Blog> = ArrayList()
    private var mListSession:ArrayList<Session> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_home_screen, container, false)
        val dbhelper= activity?.let { Dbhelper(it) }
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

        v.ivVideoLibrary.setOnClickListener {
            val intent=Intent(activity,FitzohVideoLibraryActivity::class.java)
            startActivity(intent)
        }

     /*   val fitzohvideo1= Fitzohvideo(
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
                mList3,object :RecyclerAdapterVideoLibrary.CellClickListener
                {
                    override fun onCellClickistener(myobject: Fitzohvideo, position: Int) {
                        val intent = Intent(
                            activity,
                            FitzohVideoLibraryActivity::class.java
                        )
                        intent.putExtra("fitzohvideo", myobject)
                        intent.putExtra("position", position)
                        startActivity(intent)
                    }

                }
            )
        }*/


        mListBlog= dbhelper!!.getblog()
        val blog= Blog()
        Log.d("imageeeeeee","->"+blog.bImage)

        v.rvBlog.layoutManager=LinearLayoutManager(activity)
        v.rvBlog.adapter= activity?.let {
            RecyclerAdapterBlog(it,mListBlog,object :RecyclerAdapterBlog.CellClickListener{
                override fun onCellClickistener(myobject: Blog, position: Int) {
                    val intent=Intent(activity,BlogActivity::class.java)
                    intent.putExtra("blog",myobject)
                    intent.putExtra("position",position)
                    startActivity(intent)
                }

            })
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
        v.cvTrackNutrition.setOnClickListener {
            val intent=Intent(activity, NutritionPlanActivity::class.java)
            startActivity(intent)
        }
        v.cvTrackWorkout.setOnClickListener {
            val intent=Intent(activity, CheckWorkOutActivity::class.java)
            startActivity(intent)
        }
        v.ivFitnessTest.setOnClickListener {
            val intent=Intent(activity, ListOfTestActivity::class.java)
            startActivity(intent)
        }
        v.ivFindplan.setOnClickListener {
            val intent=Intent(activity, SelectPlanActivity::class.java)
            startActivity(intent)
        }
        v.ivWollesti.setOnClickListener {
            val intent=Intent(activity, HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }

        val session1= Session(R.drawable.img_strength,"Strength")
        val session2= Session(R.drawable.img_yoga,"Yoga")
        val session3= Session(R.drawable.img_meditation,"Meditation")
        val session4= Session(R.drawable.img_endurance,"Endurance")


        mListSession.add(session1)
        mListSession.add(session2)
        mListSession.add(session3)
        mListSession.add(session4)

        v.rvBooklivesession.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        v.rvBooklivesession.adapter= activity?.let { RecyclerAdapterBookLiveSession(it,mListSession) }



        val trainer=dbhelper?.gettrainer()
        val counsellor=dbhelper?.getcounsellor()

        v.tvTrainerName.setText(trainer?.trainername)
        v.tvTrainerId.setText(trainer?.id.toString())
        v.tvCounsellorName.setText(counsellor?.counsellorname)
        v.tvCounsellorId.setText(counsellor?.id.toString())
        activity?.let { Glide.with(it).load(trainer!!.trainerimage).into(v.ivTrainerProfile) }
        activity?.let { Glide.with(it).load(counsellor!!.counsellorimage).into(v.ivCounceller) }
        return v
    }
    }
