package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_counsellor.*
import kotlinx.android.synthetic.main.fragment_home_screen.*
import kotlinx.android.synthetic.main.fragment_profile.*

class CounsellorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counsellor)

        ivBack.setOnClickListener {
            finish()
        }
       btnSelectNutritionist.setOnClickListener {
           val intent=Intent(this,SummaryActivity::class.java)
           startActivity(intent)
       }

        val dbhelper=Dbhelper(this)
        val counsellor=dbhelper.getcounsellor()


        tvCOunsellorExperince.setText(counsellor.counsellorexperience)
        tvCounsellorLanguage.setText(counsellor.counsellorlanguage)
        tvCOunsellorDescription.setText(counsellor.counsellorabout)
        tvCounselllorName.setText(counsellor.counsellorname)
       Glide.with(this).load(counsellor.counsellorimage).into(ivCounsellorPic)
    }
}