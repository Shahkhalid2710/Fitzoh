package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.ViewPagerFragmentAdapter
import com.applocum.fitzoh.ui.mainscreen.adapters.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_holistic_health_transfer.*

class HolisticHealthTransferActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_holistic_health_transfer)
        ivBack.setOnClickListener {
            finish()
        }

        val viewPagerFragmentAdapter=ViewPagerFragmentAdapter(this,supportFragmentManager)
        viewPagerFragmentAdapter.addfragment(BasicPackageFragment(),"Basic Package")
        viewPagerFragmentAdapter.addfragment(StandardFragment(),"Standard")
        viewPagerFragmentAdapter.addfragment(PremiumFragment(),"Premium")

        viewPager.adapter=viewPagerFragmentAdapter
        tablayout.setupWithViewPager(viewPager)

    }
}