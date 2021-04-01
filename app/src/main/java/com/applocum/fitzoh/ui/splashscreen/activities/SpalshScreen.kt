@file:Suppress("DEPRECATION")

package com.applocum.fitzoh.ui.splashscreen.activities
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.bottomnavigation.activities.HomeActivity
import com.applocum.fitzoh.ui.mainscreen.activities.MainActivity

@Suppress("DEPRECATION")
class SpalshScreen : AppCompatActivity() {
    private lateinit var sharedPreferences : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spalsh_screen)
        val prefs = PreferenceManager.getDefaultSharedPreferences(this)
        if (!prefs.getBoolean("firstTime", false)) {
            val dbhelper=Dbhelper(this)
            dbhelper.trainerprofile()
            dbhelper.counsellorprofile()
            dbhelper.slotbooking()
            dbhelper.fitnesslist()
            dbhelper.maincategory()
            dbhelper.subcategory()
            dbhelper.blog()
            dbhelper.workout()
            dbhelper.basicpackage()
            dbhelper.standardpackage()
            dbhelper.premiumpackage()
            dbhelper.sessioncategory()
            dbhelper.sessionsubcategory()
            // mark first time has ran.
            val editor = prefs.edit()
            editor.putBoolean("firstTime", true)
            editor.apply()
        }


        Handler().postDelayed({
            sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
            if (sharedPreferences.getString("email","").toString().isBlank())
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