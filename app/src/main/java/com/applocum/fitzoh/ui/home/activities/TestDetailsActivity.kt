package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTestHistory
import com.applocum.fitzoh.ui.home.models.TestHistory
import kotlinx.android.synthetic.main.activity_test_details.*

class TestDetailsActivity : AppCompatActivity() {
       var mList:ArrayList<TestHistory> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_details)
        ivBack.setOnClickListener {
            finish()
        }
       val testHistory1= TestHistory(
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

        btnStartTest.setOnClickListener {
            val intent=Intent(this,
                StartFitnessTestActivity::class.java)
            startActivity(intent)
        }

    }
}