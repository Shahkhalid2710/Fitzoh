package com.applocum.fitzoh.ui.home.activities

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Window
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTestHistory
import com.applocum.fitzoh.ui.home.models.FitnessTest
import com.applocum.fitzoh.ui.home.models.ListOfTest
import com.applocum.fitzoh.ui.home.models.TestHistory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_test_details.*
import kotlinx.android.synthetic.main.custom_xml.*
import kotlinx.android.synthetic.main.raw_listoftest_xml.*

class TestDetailsActivity : AppCompatActivity() {
       var mList:ArrayList<FitnessTest> = ArrayList()
       var currentposition=0
       var listOfTest:ListOfTest?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_details)
        ivBack.setOnClickListener {
            finish()
        }
        val dbhelper=Dbhelper(this)

        listOfTest = intent.getSerializableExtra("listoftest") as ListOfTest?
        currentposition= intent.getIntExtra("position",0)

        tvListName.text=listOfTest?.Listname
        tvListAbout.text=listOfTest?.Listdescription
        Glide.with(this).load(listOfTest?.Listimage).into(ivVideo)

       // vvList.setVideoPath(listOfTest?.Listvideo)
        //vvList.start()
         ivVideo.setOnClickListener {
             val metrics: DisplayMetrics = resources.displayMetrics

             val DeviceTotalWidth = metrics.widthPixels
             val DeviceTotalHeight = metrics.heightPixels

             val dialog = Dialog(this)
             dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
             dialog.setContentView(R.layout.custom_xml)
             dialog.window!!.setLayout(DeviceTotalWidth, DeviceTotalHeight)
             dialog.window?.setBackgroundDrawableResource(R.color.tp)

          //   dialog.videoview.setVideoURI(Uri.parse("android.resource://" + packageName + "/" + listOfTest?.Listvideo))
             dialog.videoview.setVideoPath(listOfTest?.Listvideo)
             dialog.videoview.start()
             dialog.ivCancel.setOnClickListener {
                 dialog.cancel()
             }
             dialog.show()
         }
         mList=dbhelper.getFitnesstest()
         var fitnessTest=FitnessTest()

        rvTestHistory.layoutManager=LinearLayoutManager(this)
        rvTestHistory.adapter=RecyclerAdapterTestHistory(this,mList)

      /*  val testHistory1= TestHistory(
           "Monday",
           "May 11, 2020",
           "01:20",
           "02:10",
           "02:15",
           "05",
           "45",
           "30",
           "4/10",
           "8/10",
           "5/10"
       )
       val testHistory2= TestHistory(
           "Sunday",
           "May 10, 2020",
           "01:20",
           "02:10",
           "02:15",
           "05",
           "45",
           "30",
           "4/10",
           "8/10",
           "5/10"
       )

        mList.add(testHistory1)
        mList.add(testHistory2)

        rvTestHistory.layoutManager=LinearLayoutManager(this)
        rvTestHistory.adapter=
            RecyclerAdapterTestHistory(
                this,
                mList
            )
*/
        btnStartTest.setOnClickListener {
            val intent=Intent(this,
                StartFitnessTestActivity::class.java)
            startActivity(intent)
        }

    }
}