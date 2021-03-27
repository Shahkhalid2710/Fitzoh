package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Counsellor
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_summary.*
import kotlinx.android.synthetic.main.activity_summary.ivBack

class SummaryActivity : AppCompatActivity() {
    private lateinit var counsellor:Counsellor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_summary)
        ivBack.setOnClickListener {
            finish()
        }
        counsellor= intent.getSerializableExtra("counsellor") as Counsellor
        btnCheckOut.setOnClickListener {
          val intent=Intent(this,SelectCalenderActivity::class.java)
          startActivity(intent)
      }
        tvCounsellorViewProfile.setOnClickListener {
            val intent=Intent(this,CounsellorActivity::class.java)
            intent.putExtra("counsellor",counsellor)
            startActivity(intent)
        }

      //  val dbhelper= Dbhelper(this)
      //  val counsellor=dbhelper.getcounsellor()
        tvCounsellorExperince.text = counsellor.counsellorexperience
        tvCounsellorabout.text = counsellor.counsellorabout
        tvCounsellorName.text = counsellor.counsellorname
        tvCounsellorPrice.text = counsellor.counsellorprice
        Glide.with(this).load(counsellor.counsellorimage).into(ivPic)

    }
}