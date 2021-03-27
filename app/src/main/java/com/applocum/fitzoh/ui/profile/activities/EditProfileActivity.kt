package com.applocum.fitzoh.ui.profile.activities

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import kotlinx.android.synthetic.main.activity_edit_profile.*

class EditProfileActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        ivBack.setOnClickListener {
            finish()
        }

        val dbhelper = Dbhelper(this)
        sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
        val email=sharedPreferences.getString("email","")

        val user= email?.let { dbhelper.signin(it) }
        etusername.setText(user?.userName)
        etDOB.setText(user?.userDOB)
        etgender.setText(user?.userGender)
        etheight.setText(user?.userHeight)
        etweight.setText(user?.userWeight)
        etdailyactivity.setText(user?.dailyactivity)
        etmealType.setText(user?.mealtype)
    }
}