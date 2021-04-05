package com.applocum.fitzoh.ui.home.fitnesstest.activities

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.fitnesstest.adapters.RecyclerAdapterTestHistory
import com.applocum.fitzoh.ui.home.fitnesstest.models.FitnessTest
import com.applocum.fitzoh.ui.home.fitnesstest.models.ListOfTest
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.prolificinteractive.materialcalendarview.CalendarDay
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener
import kotlinx.android.synthetic.main.activity_test_details.*
import kotlinx.android.synthetic.main.activity_test_details.ivBack
import kotlinx.android.synthetic.main.activity_test_details.ivPlay
import kotlinx.android.synthetic.main.custom_xml.ivCancel
import kotlinx.android.synthetic.main.custom_youtube_video.*
import java.text.ParseException
import java.text.SimpleDateFormat

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS", "DEPRECATION")
class TestDetailsActivity : AppCompatActivity(), OnDateSelectedListener {
    var mList: ArrayList<FitnessTest> = ArrayList()
    private var currentposition = 0
    private var listOfTest: ListOfTest? = null
    private var seleteddate: String = ""

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
            ivPlay.visibility=View.GONE
            val metrics: DisplayMetrics = resources.displayMetrics
            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_youtube_video)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(listOfTest!!.Listvideo, 0f)
                }
            })

            dialog.ivCancel.setOnClickListener {
                ivPlay.visibility= View.VISIBLE
                dialog.cancel()
            }
            dialog.show()
        }

        val id: Int = listOfTest!!.id
        mList = dbhelper.getFitnesstest(id)
        rvTestHistory.layoutManager = LinearLayoutManager(this)
        rvTestHistory.adapter =
            RecyclerAdapterTestHistory(
                this,
                mList
            )

        btnStartTest.setOnClickListener {
            if (seleteddate == "") {
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
    }
}