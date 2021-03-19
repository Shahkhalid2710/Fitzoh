package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterCategories
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterCategory
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterListOfTest
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterRawCategory
import com.applocum.fitzoh.ui.home.models.Categories
import com.applocum.fitzoh.ui.home.models.Category
import com.applocum.fitzoh.ui.home.models.CategoryRaw
import com.applocum.fitzoh.ui.home.models.ListOfTest
import kotlinx.android.synthetic.main.activity_fitzoh_video_library.*
import kotlinx.android.synthetic.main.activity_fitzoh_video_library.ivBack
import kotlinx.android.synthetic.main.activity_list_of_test.*

class FitzohVideoLibraryActivity : AppCompatActivity() {

    var mListmainCategory: ArrayList<Category> = ArrayList()
    var mList2: ArrayList<Categories> = ArrayList()
    var mList3: ArrayList<Categories> = ArrayList()
    var mListPerfomance: ArrayList<Categories> = ArrayList()

    var mainList: ArrayList<CategoryRaw> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitzoh_video_library)

        val dbhelper = Dbhelper(this)
        mListmainCategory = dbhelper.getmaincategory()

        rvFitzohLibrary.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFitzohLibrary.adapter = RecyclerAdapterCategory(this, mListmainCategory,object :RecyclerAdapterCategory.CellClickListener{
            override fun onCellClickistener(myobject: Category, position: Int) {

            }

        })




        val categories1 = Categories(
            R.drawable.mindimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )
        val categories2 = Categories(
            R.drawable.mindimage2,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.one
        )
        val categories3 = Categories(
            R.drawable.mindimage3,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.two
        )
        val categories8 = Categories(
            R.drawable.mindimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.three
        )

        mList2.add(categories1)
        mList2.add(categories2)
        mList2.add(categories3)
        mList2.add(categories8)

        val categories4 = Categories(
            R.drawable.relationshipimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )
        val categories5 = Categories(
            R.drawable.relationshipimage2,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.one
        )
        val categories6 = Categories(
            R.drawable.relationshipimage3,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.two
        )
        val categories7 = Categories(
            R.drawable.relationshipimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.three
        )

        mList3.add(categories4)
        mList3.add(categories5)
        mList3.add(categories6)
        mList3.add(categories7)


        val categories9 = Categories(
            R.drawable.mindimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )
        val categories10 = Categories(
            R.drawable.mindimage2,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )
        val categories11 = Categories(
            R.drawable.mindimage3,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )
        val categories12 = Categories(
            R.drawable.mindimage1,
            "Lorem ipsum dolor sit amet, consectetur adip.",
            R.raw.abc
        )

        mListPerfomance.add(categories9)
        mListPerfomance.add(categories10)
        mListPerfomance.add(categories11)
        mListPerfomance.add(categories12)


        val categoryRaw1 = CategoryRaw("Mind", mList2)
        val categoryRaw2 = CategoryRaw("Relationships", mList3)
        val categoryRaw3 = CategoryRaw("Perfomance", mListPerfomance)

        mainList.add(categoryRaw1)
        mainList.add(categoryRaw2)
        mainList.add(categoryRaw3)

        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList)

        ivBack.setOnClickListener {
            finish()
        }
    }
}