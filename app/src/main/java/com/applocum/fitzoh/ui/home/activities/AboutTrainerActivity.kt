package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.ViewPagerFragmentAdapter
import kotlinx.android.synthetic.main.activity_about_trainer.*

class AboutTrainerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_trainer)
        ivBack.setOnClickListener {
            finish()
        }

       val viewPagerFragmentAdapter=
           ViewPagerFragmentAdapter(
               this,
               supportFragmentManager
           )
       viewPagerFragmentAdapter.addfragment(SlotBookingFragment(),"SLOT BOOKING")
       viewPagerFragmentAdapter.addfragment(GalleryFragment(),"GALLERY")

        viewPager.adapter=viewPagerFragmentAdapter
        tablayout.setupWithViewPager(viewPager)

    }
}