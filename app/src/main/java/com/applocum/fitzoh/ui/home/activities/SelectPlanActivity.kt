package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_select_plan.*

class SelectPlanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_plan)
        ivBack.setOnClickListener {
            finish()
        }
        ivBeginner.setOnClickListener {
            Toast.makeText(this,"You select Beginner",Toast.LENGTH_SHORT).show()
            finish()
        }
        ivIntermedeter.setOnClickListener {
            Toast.makeText(this,"You select Intermediate",Toast.LENGTH_SHORT).show()
            finish()
        }
        ivAdvance.setOnClickListener {
            Toast.makeText(this,"You select Advance",Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}