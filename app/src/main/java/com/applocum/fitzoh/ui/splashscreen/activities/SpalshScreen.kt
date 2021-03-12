package com.applocum.fitzoh.ui.splashscreen.activities

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.applocum.fitzoh.ui.bottomnavigation.activities.HomeActivity
import com.applocum.fitzoh.ui.mainscreen.activities.MainActivity
import com.applocum.fitzoh.R

class SpalshScreen : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)

        Handler().postDelayed({
            sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
            if (sharedPreferences.getString("email","").toString().isNullOrBlank())
            {
                val intent= Intent(this, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }else
            {
                val intent= Intent(this, HomeActivity::class.java)
                startActivity(intent)
                finish()
            }

        },1000)

    }
}