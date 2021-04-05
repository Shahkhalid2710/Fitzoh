package com.applocum.fitzoh.ui.home.counsellor.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.counsellor.models.Counsellor
import com.applocum.fitzoh.ui.home.wholestichealthandwellness.models.Packages
import com.applocum.fitzoh.ui.home.wholestichealthandwellness.activities.SummaryActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_counsellor.*

class CounsellorActivity : AppCompatActivity() {
    private lateinit var counsellor: Counsellor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counsellor)

        val packages=intent.getSerializableExtra("packages") as Packages
        ivBack.setOnClickListener {
            finish()
        }
       btnSelectNutritionist.setOnClickListener {
           val intent=Intent(this,
               SummaryActivity::class.java)
           intent.putExtra("counsellor",counsellor)
           intent.putExtra("packages",packages)
           startActivity(intent)
       }
       counsellor= intent.getSerializableExtra("counsellor") as Counsellor
        tvCOunsellorExperince.text = counsellor.counsellorexperience
        tvCounsellorLanguage.text = counsellor.counsellorlanguage
        tvCOunsellorDescription.text = counsellor.counsellorabout
        tvCounselllorName.text = counsellor.counsellorname
        Glide.with(this).load(counsellor.counsellorimage).into(ivCounsellorPic)
    }
}