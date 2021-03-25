package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionNumber
import com.applocum.fitzoh.ui.home.adapters.ViewPagerFragmentAdapter
import com.applocum.fitzoh.ui.home.models.Sessionnumber
import com.applocum.fitzoh.ui.home.models.Trainer
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_about_trainer.*
import kotlinx.android.synthetic.main.activity_about_trainer.ivBack
import kotlinx.android.synthetic.main.activity_live_session.*
import kotlinx.android.synthetic.main.raw_xml_time.*

class AboutTrainerActivity : AppCompatActivity() {
    lateinit var trainer:Trainer
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


      //  trainer= intent.getSerializableExtra("trainer") as Trainer

        val dbhelper=Dbhelper(this)
        val trainer=dbhelper.gettrainer()

        tvName.setText(trainer.trainername)
        tvExperince.setText(trainer.trainerexperince)
        tvLanguage.setText(trainer.trainerlanguage)
        tvTrainerAbout.setText(trainer.trainerabout)

        Glide.with(this).load(trainer.trainerimage).into(ivPic)


    }
}