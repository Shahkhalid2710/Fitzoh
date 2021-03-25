package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSession
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionTrainer
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.models.*
import kotlinx.android.synthetic.main.activity_select_calender.*

class SelectCalenderActivity : AppCompatActivity() {
    var mListSessionCategory:ArrayList<SessionCategory> = ArrayList()
    var mListSessionTrainer:ArrayList<Trainer> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_calender)
       ivBack.setOnClickListener {
           finish()
       }
        val dbhelper=Dbhelper(this)
         mListSessionCategory=dbhelper.getSessioncategory()


        rvType.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvType.adapter=RecyclerAdapterSession(this,mListSessionCategory)


         mListSessionTrainer= dbhelper.getallTrainer()
        rvTrainer.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvTrainer.adapter=RecyclerAdapterSessionTrainer(this,mListSessionTrainer)

    }
}