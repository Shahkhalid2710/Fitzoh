package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.ViewPagerFragmentAdapter
import com.applocum.fitzoh.ui.home.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about_trainer.*
import kotlinx.android.synthetic.main.activity_about_trainer.ivBack

class AboutTrainerActivity : AppCompatActivity() {
    lateinit var trainer:Trainer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_trainer)
        ivBack.setOnClickListener {
            finish()
        }

       val viewPagerFragmentAdapter= ViewPagerFragmentAdapter(this, supportFragmentManager)
       viewPagerFragmentAdapter.addfragment(SlotBookingFragment(),"SLOT BOOKING")
       viewPagerFragmentAdapter.addfragment(GalleryFragment(),"GALLERY")
        viewPager.adapter=viewPagerFragmentAdapter
        tablayout.setupWithViewPager(viewPager)

        val dbhelper=Dbhelper(this)
        val trainer=dbhelper.gettrainer()

        tvName.text = trainer.trainername
        tvExperince.text = trainer.trainerexperince
        tvLanguage.text = trainer.trainerlanguage
        tvTrainerAbout.text = trainer.trainerabout
        Glide.with(this).load(trainer.trainerimage).into(ivPic)
    }
}