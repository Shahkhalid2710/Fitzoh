package com.applocum.fitzoh.ui.calender.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.calender.adapters.RecyclerAdapterDiet
import com.applocum.fitzoh.ui.calender.adapters.RecyclerAdapterExercise
import com.applocum.fitzoh.ui.calender.adapters.RecyclerAdapterSessionDay
import com.applocum.fitzoh.ui.calender.models.Diet
import com.applocum.fitzoh.ui.calender.models.Exercise
import com.applocum.fitzoh.ui.calender.models.SessionDay
import com.applocum.fitzoh.ui.home.activities.CheckWorkOutActivity
import com.applocum.fitzoh.ui.home.activities.StrengthSessionActivity
import kotlinx.android.synthetic.main.fragment_calender.*
import kotlinx.android.synthetic.main.fragment_calender.view.*
import kotlinx.android.synthetic.main.fragment_calender.view.tvName

class CalenderFragment : Fragment() {
    var mListDiet:ArrayList<Diet> = ArrayList()
    var mListExercise:ArrayList<Exercise> = ArrayList()
    var mListSessionDay:ArrayList<SessionDay> = ArrayList()
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_calender, container, false)

        val diet1=Diet("Breakfast","Boiled Egg","5 Medium",0,"Kiwi Fruit","2 Fruits",0)
        val diet2=Diet("Lunch","Boiled Egg","5 Medium",0,"Kiwi Fruit","2 Fruits",0)
        val diet3=Diet("Snacks","Boiled Egg","5 Medium",0,"Kiwi Fruit","2 Fruits",0)
        val diet4=Diet("Dinner","Boiled Egg","5 Medium",0,"Kiwi Fruit","2 Fruits",0)

        mListDiet.add(diet1)
        mListDiet.add(diet2)
        mListDiet.add(diet3)
        mListDiet.add(diet4)

        v.rvdiet.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false )
        v.rvdiet.adapter= activity?.let { RecyclerAdapterDiet(it,mListDiet,object :RecyclerAdapterDiet.CellClickListener{
            override fun onCellClickistener(myobject: Diet, position: Int) {
            }
        }) }

        val exercise1=Exercise("03","03")
        val exercise2=Exercise("04","02")

        mListExercise.add(exercise1)
        mListExercise.add(exercise2)

        v.rvexercise.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false )
        v.rvexercise.adapter= activity?.let { RecyclerAdapterExercise(it,mListExercise,object :RecyclerAdapterExercise.CellClickListener{
            override fun onCellClickistener(myobject: Exercise, position: Int) {
                val intent=Intent(activity, CheckWorkOutActivity::class.java)
                intent.putExtra("exercise",myobject)
                intent.putExtra("position",position)
                startActivity(intent)
            }
        }) }

        val sessionDay1=SessionDay("Yoga",R.drawable.img_yoga,"Yoga","By Nina","08:00 AM","10:00 AM","12:00 PM")
        val sessionDay2=SessionDay("Flexibility",R.drawable.image_flexibility,"Flexibility","By Ena","04:00 PM","06:00 PM","08:00 PM")
        val sessionDay3=SessionDay("Meditation",R.drawable.img_meditation,"Meditation","By Jenna","09:00 PM","11:00 PM","01:00 AM")

        mListSessionDay.add(sessionDay1)
        mListSessionDay.add(sessionDay2)
        mListSessionDay.add(sessionDay3)

        v.rvSesionday.layoutManager=LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false )
        v.rvSesionday.adapter= activity?.let { RecyclerAdapterSessionDay(it,mListSessionDay,object:RecyclerAdapterSessionDay.CellClickListener{
            override fun onCellClickistener(myobject: SessionDay, position: Int) {
                val intent=Intent(activity,StrengthSessionActivity::class.java)
                intent.putExtra("sessionday",myobject)
                intent.putExtra("position",position)
                startActivity(intent)
            }
        }) }

        val dbhelper= activity?.let { Dbhelper(it) }
        val progress=dbhelper?.getProgress()
        sharedPreferences= activity?.getSharedPreferences("mypref",AppCompatActivity.MODE_PRIVATE)!!
        val email=sharedPreferences.getString("email","")

        val user= email?.let { dbhelper?.signin(it) }
        v.tvName.text = user?.userName
        v.cvprogress.setOnClickListener {
            val intent=Intent(activity,ProgressDetailsActivty::class.java)
            intent.putExtra("progress",progress)
            startActivity(intent)
        }
        return v
    }

    override fun onResume() {
        super.onResume()
        val dbhelper= activity?.let { Dbhelper(it) }
        val progress=dbhelper?.getProgress()
        tvWeightvalue.text = progress?.uWeight
        tvHeightvalue.text = progress?.uHeight
        tvbodyfatvalue.text = progress?.uBodyfat
        tvarmvalue.text = progress?.uArm
        tvChestvalue.text =progress?.uChest

    }
}