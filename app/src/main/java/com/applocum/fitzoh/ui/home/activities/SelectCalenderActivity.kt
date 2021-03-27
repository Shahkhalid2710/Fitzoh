package com.applocum.fitzoh.ui.home.activities

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSession
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionTrainer
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.models.*
import com.google.android.material.snackbar.Snackbar
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.activity_select_calender.*
import kotlinx.android.synthetic.main.activity_select_calender.btnSubmit
import kotlinx.android.synthetic.main.activity_select_calender.calendarView
import kotlinx.android.synthetic.main.activity_select_calender.ivBack
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION",
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING"
)
class SelectCalenderActivity : AppCompatActivity(), OnDateSelectedListener {
    private var mListSessionCategory: ArrayList<SessionCategory> = ArrayList()
    var mListSessionTrainer = ArrayList<Trainer>()
    private var mList: ArrayList<String> = ArrayList()
    private var seleteddate: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_calender)
        ivBack.setOnClickListener {
            finish()
        }
        calendarView.setOnDateChangedListener(this)
        val dbhelper = Dbhelper(this)
        mListSessionCategory = dbhelper.getSessioncategory()
        rvType.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvType.adapter = RecyclerAdapterSession(this, mListSessionCategory, object :RecyclerAdapterSession.CellClickListener {
            override fun onCellClickistener(myobject: SessionCategory, position: Int) {

               mListSessionTrainer=dbhelper.getparticulartrainer(myobject.id)
                val recyclerAdapterSessionTrainer=RecyclerAdapterSessionTrainer(this@SelectCalenderActivity,mListSessionTrainer)

                   rvTrainer.layoutManager = LinearLayoutManager(this@SelectCalenderActivity, LinearLayoutManager.HORIZONTAL, false)
                   rvTrainer.adapter =recyclerAdapterSessionTrainer
                   recyclerAdapterSessionTrainer.notifyDataSetChanged()
            }

        })

        btnSubmit.setOnClickListener {
            if (seleteddate == "") {
                val snackbar =
                    Snackbar.make(llselectcalender, "Please Select Date", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
        }

    }

    @SuppressLint("SimpleDateFormat")
    override fun onDateSelected(
        widget: MaterialCalendarView,
        date1: CalendarDay,
        selected: Boolean
    ) {
        if (!mList.isNullOrEmpty())
        {
            mList.clear()
        }

        var date=date1.date
        val formatter =
            SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy")
        val temp:String =date.date.toString()
        try {
            date = formatter.parse(temp)
            Log.e("dateeeeeee", date.toString() + "")
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        val formateDate = SimpleDateFormat("yyyy-MM-dd").format(date)
        seleteddate=formateDate
        val dbhelper=Dbhelper(this)
        val slotbooking=dbhelper.getslotbooking(seleteddate)
        Log.d("slotbookinggendtime","-->"+slotbooking?.slotstarttime)

        if (!slotbooking?.slotstarttime.isNullOrBlank())
        {

            var a =""
            var b =""
            if (slotbooking != null) a=slotbooking.slotstarttime
            if (slotbooking != null) b=slotbooking.slotendtime
            val format = "hh:mm aaa"
            val sdf = SimpleDateFormat(format)
            val date1=sdf.parse(a)
            val date2=sdf.parse(b)
            var dif: Long = date1.time
            while (dif < date2.time) {
                val slot = Date(dif)
                dif += 3600000
                val formateDate2 = SimpleDateFormat("hh:mm a").format(slot)

                mList.add(formateDate2)
            }
            rvSessionBooking.layoutManager=GridLayoutManager(this,3)
            rvSessionBooking.adapter= RecyclerAdapterSlotBookingTime(this,mList,object :RecyclerAdapterSlotBookingTime.CellClickListener{
                override fun onCellClickistener(myobject: String, position: Int) {
                    btnSubmit.visibility=View.VISIBLE

                }
            })
        }
        else
        {
            mList.clear()
            Toast.makeText(this,"Session not book",Toast.LENGTH_SHORT).show()

        }
    }
}