package com.applocum.fitzoh.ui.home.activities


import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSlotBookingTime
import com.applocum.fitzoh.ui.home.models.Slotbooking
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.fragment_slot_booking.*
import kotlinx.android.synthetic.main.fragment_slot_booking.view.*
import kotlinx.android.synthetic.main.raw_xml_time.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "NAME_SHADOWING",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)
class SlotBookingFragment : Fragment(), OnDateSelectedListener {
    private var mList:ArrayList<String> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_slot_booking, container, false)
         v.calendarView.setOnDateChangedListener(this)
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

        val dbhelper= activity?.let { Dbhelper(it) }
        val slotbooking=dbhelper?.getslotbooking(formateDate)
        Log.d("slotbookinggendtime","-->"+slotbooking?.slotstarttime)

         if (!slotbooking?.slotstarttime.isNullOrBlank())
         {
             //Log.d("slotbookinggidd","-->"+slotbooking?.id)

             var a:String=""
             var b:String=""
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
             rvSlotbooking.adapter= activity?.let { RecyclerAdapterSlotBookingTime(it,mList,object :RecyclerAdapterSlotBookingTime.CellClickListener{
                 override fun onCellClickistener(myobject: String, position: Int) {
                     btnSubmit.visibility=View.VISIBLE

                 }

             }) }
         }
        else
         {
             Toast.makeText(activity,"Slot not available",Toast.LENGTH_SHORT).show()
         }

    }
}