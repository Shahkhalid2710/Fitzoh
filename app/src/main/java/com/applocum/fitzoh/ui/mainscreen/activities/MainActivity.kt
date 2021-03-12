package com.applocum.fitzoh.ui.mainscreen.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import androidx.viewpager.widget.ViewPager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.signin.activities.SignInActivity
import com.applocum.fitzoh.ui.signup.activities.SignUpActivity
import com.applocum.fitzoh.ui.mainscreen.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var mViewPager: ViewPager? = null
    private var images = intArrayOf(
        R.drawable.backgroundlogo,
        R.drawable.fitimage,
        R.drawable.fitimage2
    )
    private var mViewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       // window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        mViewPager =findViewById(R.id.viewpager)
        mViewPagerAdapter =
            ViewPagerAdapter(
                this@MainActivity,
                images
            )
        mViewPager!!.adapter=mViewPagerAdapter

        val tabLayout: TabLayout = findViewById(R.id.tablayout)
        tabLayout.setupWithViewPager(mViewPager,true)

        btnSignup.setOnClickListener {
            val intent=Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        btnSignin.setOnClickListener {
            val intent=Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }
}