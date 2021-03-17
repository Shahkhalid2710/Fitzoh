package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_blog.*
import kotlinx.android.synthetic.main.activity_goal_setting.*
import kotlinx.android.synthetic.main.activity_goal_setting.ivBack

class BlogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        ivBack.setOnClickListener {
            finish()
        }
    }
}