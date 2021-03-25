package com.applocum.fitzoh.ui.home.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTestHistory
import com.applocum.fitzoh.ui.home.models.FitnessTest
import com.applocum.fitzoh.ui.home.models.ListOfTest
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.activity_start_fitness_test.*
import kotlinx.android.synthetic.main.activity_test_details.*
import kotlinx.android.synthetic.main.activity_test_details.ivBack
import kotlinx.android.synthetic.main.custom_xml.*
import kotlinx.android.synthetic.main.raw_listoftest_xml.*
import java.text.ParseException
import java.text.SimpleDateFormat

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class TestDetailsActivity : AppCompatActivity(), OnDateSelectedListener {
    var mList: ArrayList<FitnessTest> = ArrayList()
    var currentposition = 0
    var listOfTest: ListOfTest? = null
    var seleteddate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_details)
        ivBack.setOnClickListener {
            finish()
        }
        calendarView.setOnDateChangedListener(this)
        val dbhelper = Dbhelper(this)

        listOfTest = intent.getSerializableExtra("listoftest") as ListOfTest?
        currentposition = intent.getIntExtra("position", 0)

        tvListName.text = listOfTest?.Listname
        tvListAbout.text = listOfTest?.Listdescription
        Glide.with(this).load(listOfTest?.Listimage).into(ivVideo)

        ivVideo.setOnClickListener {
            val metrics: DisplayMetrics = resources.displayMetrics

            val DeviceTotalWidth = metrics.widthPixels
            val DeviceTotalHeight = metrics.heightPixels

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_xml)
            dialog.window!!.setLayout(DeviceTotalWidth, DeviceTotalHeight)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)
            dialog.videoview.setVideoPath(listOfTest?.Listvideo)
            dialog.videoview.start()
            dialog.ivCancel.setOnClickListener {
                dialog.cancel()
            }
            dialog.show()
        }

        val id: Int = listOfTest!!.id
        Log.d("testid", "-->" + id)
        mList = dbhelper.getFitnesstest(id)
        rvTestHistory.layoutManager = LinearLayoutManager(this)
        rvTestHistory.adapter = RecyclerAdapterTestHistory(this, mList)

        btnStartTest.setOnClickListener {
            if (seleteddate.equals("")) {
                val snackbar = Snackbar.make(lltestdetails, "Please Select Date", Snackbar.LENGTH_LONG)
                snackbar.show()
            }
            else
            {
                val intent = Intent(
                    this,
                    StartFitnessTestActivity::class.java
                )
                intent.putExtra("listoftest", listOfTest)
                intent.putExtra("position", currentposition)
                intent.putExtra("selecteddate", seleteddate)
                startActivity(intent)
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    override fun onDateSelected(
        widget: MaterialCalendarView,
        date1: CalendarDay,
        selected: Boolean
    ) {
        var date = date1.date
        val formatter =
            SimpleDateFormat("EEE MMM dd HH:mm:ss zzzz yyyy")
        val temp: String = date.date.toString()
        try {
            date = formatter.parse(temp)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        val formateDate = SimpleDateFormat("dd-MM-yyyy").format(date)
        seleteddate = formateDate
        Log.d("dateeee", "-->" + seleteddate)

    }
}