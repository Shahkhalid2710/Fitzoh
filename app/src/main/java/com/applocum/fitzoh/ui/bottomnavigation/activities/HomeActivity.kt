package com.applocum.fitzoh.ui.bottomnavigation.activities

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.applocum.fitzoh.*
import com.applocum.fitzoh.ui.calender.activities.CalenderFragment
import com.applocum.fitzoh.ui.home.activities.HomeScreenFragment
import com.applocum.fitzoh.ui.packages.activities.PackagesFragment
import com.applocum.fitzoh.ui.profile.activities.ProfileFragment
import com.applocum.fitzoh.ui.trainer.activities.TrainerFragment
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter

class HomeActivity : AppCompatActivity(), AHBottomNavigation.OnTabSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView =
            findViewById<AHBottomNavigation?>(R.id.bottom_navigation) ?: return
        val navigationAdapter = AHBottomNavigationAdapter(this,
            R.menu.custom_bottomnavigation
        )
        navigationAdapter.setupWithBottomNavigation(bottomNavigationView)
        bottomNavigationView.currentItem = 2
        bottomNavigationView.isForceTint = true
        bottomNavigationView.titleState = AHBottomNavigation.TitleState.ALWAYS_SHOW
        bottomNavigationView.accentColor = Color.parseColor("#249BCF")
        bottomNavigationView.inactiveColor = Color.parseColor("#757575")
        val fontTypeFace = Typeface.createFromAsset(assets, "fonts/poppins_medium.ttf")
        bottomNavigationView.setTitleTypeface(fontTypeFace)
        bottomNavigationView.setDefaultBackgroundResource(R.color.white)
        bottomNavigationView.setOnTabSelectedListener(this)

        val homeScreenFragment =
            HomeScreenFragment()
        loadfragment(homeScreenFragment)

    }

    override fun onTabSelected(position: Int, wasSelected: Boolean): Boolean {

        val calenderFragment =
            CalenderFragment()
        val profileFragment =
            ProfileFragment()
        val trainerFragment =
            TrainerFragment()
        val packagesFragment =
            PackagesFragment()
        val homeScreenFragment=
            HomeScreenFragment()

        when (position) {
            0 -> { loadfragment(calenderFragment) }
            1 -> { loadfragment(packagesFragment) }
            2 -> { loadfragment(homeScreenFragment) }
            3 -> { loadfragment(trainerFragment) }
            4 -> { loadfragment(profileFragment) }
        }
        return true
    }


    private fun loadfragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.myLayout, fragment)
        transaction.commit()
    }

}