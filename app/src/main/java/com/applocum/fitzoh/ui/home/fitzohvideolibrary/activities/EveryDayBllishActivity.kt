package com.applocum.fitzoh.ui.home.fitzohvideolibrary.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.fitnesstest.adapters.RecyclerAdapterVideo
import com.applocum.fitzoh.ui.home.fitzohvideolibrary.models.Categories
import com.applocum.fitzoh.ui.home.fitzohvideolibrary.models.CategoryRaw
import kotlinx.android.synthetic.main.activity_every_day_bllish.*
import kotlinx.android.synthetic.main.activity_fitzoh_video_library.ivBack


class EveryDayBllishActivity : AppCompatActivity() {
    private var mListCategories: ArrayList<Categories> = ArrayList()
    private lateinit var categories: CategoryRaw

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_every_day_bllish)

        ivBack.setOnClickListener {
            finish()
        }

        categories = intent.getSerializableExtra("categories") as CategoryRaw
        mListCategories = categories.mylist

        rvVideos.layoutManager = GridLayoutManager(this, 2)
        rvVideos.adapter =
            RecyclerAdapterVideo(
                this,
                mListCategories
            )
    }
}