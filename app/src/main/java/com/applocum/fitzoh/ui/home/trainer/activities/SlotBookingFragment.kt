package com.applocum.fitzoh.ui.home.trainer.activities


import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.trainer.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.trainer.models.Slotbooking
import com.google.android.material.snackbar.Snackbar
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.fragment_slot_booking.*
import kotlinx.android.synthetic.main.fragment_slot_booking.btnSubmit
import kotlinx.android.synthetic.main.fragment_slot_booking.view.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList
@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION"
)
class SlotBookingFragment : Fragment(), OnDateSelectedListener {
    private var mList:ArrayList<String> = ArrayList()
    private var selecttime = ""
    private var seleteddate: String = ""
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var slotbooking: Slotbooking

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_slot_booking, container, false)
         v.calendarView.setOnDateChangedListener(this)
        sharedPreferences =requireActivity().getSharedPreferences("mypref", AppCompatActivity.MODE_PRIVATE)
        v.btnSubmit.setOnClickListener {
             when {
                 seleteddate == "" -> {
                     val snackbar = Snackbar.make(llslotbooking, "Please Select Date", Snackbar.LENGTH_LONG)
                     snackbar.show()
                 }
                 selecttime == "" -> {
                     val snackbar = Snackbar.make(llslotbooking, "Please Select Time", Snackbar.LENGTH_LONG)
                     snackbar.show()
                 }
                 else -> {
                     slotbooking =
                         Slotbooking(
                             seleteddate,
                             "07:00 AM",
                             "08:00 PM",
                             selecttime
                         )
                     Toast.makeText(activity, "Successfully slot book", Toast.LENGTH_SHORT).show()
                 }
             }
         }
        return v
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
        val dbhelper= activity?.let { Dbhelper(it) }
        val slotbooking=dbhelper?.getallslotbooking()

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
             rvSlotbooking.layoutManager=GridLayoutManager(activity,3)
             rvSlotbooking.adapter= activity?.let {
                 RecyclerAdapterSlotBookingTime(
                     it,
                     mList,
                     object :
                         RecyclerAdapterSlotBookingTime.CellClickListener {
                         override fun onCellClickistener(myobject: String, position: Int) {
                             btnSubmit.visibility = View.VISIBLE
                             selecttime = myobject
                         }

                     })
             }
    }
}