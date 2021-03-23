package com.applocum.fitzoh.ui.home.activities

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterVideo
import com.applocum.fitzoh.ui.home.models.Categories
import com.applocum.fitzoh.ui.home.models.CategoryRaw
import kotlinx.android.synthetic.main.activity_every_day_bllish.*
import kotlinx.android.synthetic.main.activity_fitzoh_video_library.ivBack


class EveryDayBllishActivity : AppCompatActivity() {
    var mListCategories: ArrayList<Categories> = ArrayList()

    lateinit var categories: CategoryRaw

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_every_day_bllish)

        ivBack.setOnClickListener {
            finish()
        }

        categories = intent.getSerializableExtra("categories") as CategoryRaw
        mListCategories = categories.mylist

        rvVideos.layoutManager = GridLayoutManager(this, 2)
        rvVideos.adapter = RecyclerAdapterVideo(this, mListCategories)

    }
}