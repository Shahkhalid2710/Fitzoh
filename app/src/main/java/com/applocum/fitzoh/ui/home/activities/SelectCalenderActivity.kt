package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSession
import com.applocum.fitzoh.ui.home.models.Session
import kotlinx.android.synthetic.main.activity_select_calender.*

class SelectCalenderActivity : AppCompatActivity() {
    val mListSession:ArrayList<Session> = ArrayList()
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
    }
}