package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_summary.*

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

    }
}