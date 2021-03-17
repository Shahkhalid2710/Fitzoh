package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSession
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionTrainer
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.models.Session
import com.applocum.fitzoh.ui.home.models.SessionTrainer
import com.applocum.fitzoh.ui.home.models.Slotbooking
import kotlinx.android.synthetic.main.activity_select_calender.*

class SelectCalenderActivity : AppCompatActivity() {
    val mListSession:ArrayList<Session> = ArrayList()
    val mListSessionTrainer:ArrayList<SessionTrainer> = ArrayList()
    val mListSessionTime:ArrayList<Slotbooking> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_calender)
       ivBack.setOnClickListener {
           finish()
       }

       val session1=Session(R.drawable.strength,"Strength")
       val session2=Session(R.drawable.img_yoga,"Power Yoga")
       val session3=Session(R.drawable.image_flexibility,"Mobility & Flexibility")
       val session4=Session(R.drawable.image_yogarelex,"Yoga - Relaxation,")
       val session5=Session(R.drawable.img_meditation,"Meditation")
       val session6=Session(R.drawable.image_powerandspeed,"Powerspeed")

        mListSession.add(session1)
        mListSession.add(session2)
        mListSession.add(session3)
        mListSession.add(session4)
        mListSession.add(session5)
        mListSession.add(session6)

        rvType.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvType.adapter=RecyclerAdapterSession(this,mListSession)

        val sessionTrainer1=SessionTrainer(R.drawable.bewell,"Bewell Bykelly","Nutritionist")
        val sessionTrainer2=SessionTrainer(R.drawable.ena,"Enaa blatner","General Counsellor")
        val sessionTrainer3=SessionTrainer(R.drawable.bewell,"Bewell Bykelly","Nutritionist")
        val sessionTrainer4=SessionTrainer(R.drawable.ena,"Enaa blatner","General Counsellor")

        mListSessionTrainer.add(sessionTrainer1)
        mListSessionTrainer.add(sessionTrainer2)
        mListSessionTrainer.add(sessionTrainer3)
        mListSessionTrainer.add(sessionTrainer4)

        rvTrainer.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvTrainer.adapter=RecyclerAdapterSessionTrainer(this,mListSessionTrainer)

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

        mListSessionTime.add(slotbooking1)
        mListSessionTime.add(slotbooking2)

        rvTime.layoutManager=LinearLayoutManager(this)
        rvTime.adapter=RecyclerAdapterSlotBookingTime(this,mListSessionTime)
    }
}