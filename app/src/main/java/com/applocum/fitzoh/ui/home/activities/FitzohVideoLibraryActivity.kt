package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Toast
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

    var mainList: ArrayList<CategoryRaw> = ArrayList()
    var mainList2: ArrayList<CategoryRaw> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitzoh_video_library)

        val dbhelper = Dbhelper(this)
        mListmainCategory = dbhelper.getmaincategory()

        rvFitzohLibrary.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvFitzohLibrary.adapter = RecyclerAdapterCategory(
            this,
            mListmainCategory,
            object : RecyclerAdapterCategory.CellClickListener {
                override fun onCellClickistener(myobject: Category, position: Int) {
                    when (myobject.id) {
                        1-> allData()
                        2 -> getallmind()
                        3 -> getallrelationships()
                        4 -> getallperfomance()
                        5 -> getallfriendships()
                        else -> Toast.makeText(
                            this@FitzohVideoLibraryActivity,
                            "Error",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    Log.d("position", "-->" + myobject.id)
                }
            })

        mainList = dbhelper.getAll()
        allData()
      /*  rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)*/

        ivBack.setOnClickListener {
            finish()
        }
    }

    fun allData() {
        mainList2.clear()

        val dbhelper = Dbhelper(this)
        if (mainList.get(0).cName.equals("MIND")) {
            val categoryRawMind = CategoryRaw(mainList.get(0).cName, dbhelper.getMind())
            mainList2.add(categoryRawMind)
        }
        if (mainList.get(1).cName.equals("RELATIONSHIPS")) {
            val categoryRawRealtionships =
                CategoryRaw(mainList.get(1).cName, dbhelper.getRelationships())
            mainList2.add(categoryRawRealtionships)
        }
        if (mainList.get(2).cName.equals("PERFORMANCE")) {
            val categoryRawPerfomance = CategoryRaw(mainList.get(2).cName, dbhelper.getPerfomance())
            mainList2.add(categoryRawPerfomance)
        }
        if (mainList.get(3).cName.equals("FRIENDSHIPS")) {
            val categoryRawFriendships =
                CategoryRaw(mainList.get(3).cName, dbhelper.getFriendships())
            mainList2.add(categoryRawFriendships)
        }


        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)
    }

    fun getallmind() {
        mainList2.clear()
        val dbhelper = Dbhelper(this)
        if (mainList.get(0).cName.equals("MIND")) {
            val categoryRawMind = CategoryRaw(mainList.get(0).cName, dbhelper.getMind())
            mainList2.add(categoryRawMind)
        }
        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)
    }

    fun getallrelationships() {
        mainList2.clear()

        val dbhelper = Dbhelper(this)
        if (mainList.get(1).cName.equals("RELATIONSHIPS")) {
            val categoryRawRealtionships =
                CategoryRaw(mainList.get(1).cName, dbhelper.getRelationships())
            mainList2.add(categoryRawRealtionships)
        }
        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)
    }

    fun getallperfomance() {
        mainList2.clear()
        val dbhelper = Dbhelper(this)
        if (mainList.get(2).cName.equals("PERFORMANCE")) {
            val categoryRawPerfomance = CategoryRaw(mainList.get(2).cName, dbhelper.getPerfomance())
            mainList2.add(categoryRawPerfomance)
        }
        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)
    }

    fun getallfriendships() {
        mainList2.clear()
        Log.d("listmy","->"+mainList2)
        val dbhelper = Dbhelper(this)
        if (mainList.get(3).cName.equals("FRIENDSHIPS")) {
            val categoryRawFriendships =
                CategoryRaw(mainList.get(3).cName, dbhelper.getFriendships())
            mainList2.add(categoryRawFriendships)
        }
        rvcategories.layoutManager = LinearLayoutManager(this)
        rvcategories.adapter = RecyclerAdapterRawCategory(this, mainList2)
    }
}