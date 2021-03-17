package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionNumber
import com.applocum.fitzoh.ui.home.adapters.ViewPagerFragmentAdapter
import com.applocum.fitzoh.ui.home.models.Sessionnumber
import kotlinx.android.synthetic.main.activity_about_trainer.*
import kotlinx.android.synthetic.main.activity_about_trainer.ivBack
import kotlinx.android.synthetic.main.activity_about_trainer.rvSession
import kotlinx.android.synthetic.main.activity_live_session.*

class AboutTrainerActivity : AppCompatActivity() {
    var mListSessionNumbber:ArrayList<Sessionnumber> = ArrayList()
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

        val sessionnumber1 = Sessionnumber("Session -01")
        val sessionnumber2 = Sessionnumber("Session -02")
        val sessionnumber3 = Sessionnumber("Session -03")
        val sessionnumber4 = Sessionnumber("Session -04")
        val sessionnumber5 = Sessionnumber("Session -05")
        val sessionnumber6 = Sessionnumber("Session -06")
        val sessionnumber7 = Sessionnumber("Session -07")

        mListSessionNumbber.add(sessionnumber1)
        mListSessionNumbber.add(sessionnumber2)
        mListSessionNumbber.add(sessionnumber3)
        mListSessionNumbber.add(sessionnumber4)
        mListSessionNumbber.add(sessionnumber5)
        mListSessionNumbber.add(sessionnumber6)
        mListSessionNumbber.add(sessionnumber7)

        rvSession.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSession.adapter = RecyclerAdapterSessionNumber(this, mListSessionNumbber)


    }
}