package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_check_work_out.*

class CheckWorkOutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_work_out)

        ivBack.setOnClickListener {
            finish()
        }
    }
}