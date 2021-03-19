package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_counsellor.*
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.activity_summary.ivBack

class SummaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)

        ivBack.setOnClickListener {
            finish()
        }
      btnCheckOut.setOnClickListener {
          val intent=Intent(this,SelectCalenderActivity::class.java)
          startActivity(intent)
      }
        tvCounsellorViewProfile.setOnClickListener {
            val intent=Intent(this,CounsellorActivity::class.java)
            startActivity(intent)
        }

        val dbhelper= Dbhelper(this)
        val counsellor=dbhelper.getcounsellor()
        tvCounsellorExperince.setText(counsellor.counsellorexperience)
        tvCounsellorabout.setText(counsellor.counsellorabout)
        tvCounsellorName.setText(counsellor.counsellorname)
        tvCounsellorPrice.setText(counsellor.counsellorprice)
        Glide.with(this).load(counsellor.counsellorimage).into(ivPic)

    }
}