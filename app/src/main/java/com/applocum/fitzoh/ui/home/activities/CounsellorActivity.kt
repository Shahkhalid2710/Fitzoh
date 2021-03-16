package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_counsellor.*

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
    }
}