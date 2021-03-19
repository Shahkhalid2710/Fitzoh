package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.Blog
import com.applocum.fitzoh.ui.home.models.ListOfTest
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_blog.*
import kotlinx.android.synthetic.main.activity_goal_setting.*
import kotlinx.android.synthetic.main.activity_goal_setting.ivBack
import kotlinx.android.synthetic.main.activity_test_details.*

class BlogActivity : AppCompatActivity() {
    var currentposition=0
    var blog: Blog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        ivBack.setOnClickListener {
            finish()
        }

        blog = intent.getSerializableExtra("blog") as Blog?
        currentposition= intent.getIntExtra("position",0)

        tvBlogabout.text=blog?.bDescription
        tvLevel.text=blog?.bLevel
        Glide.with(this).load(blog?.bImage).into(ivBlog)


    }
}