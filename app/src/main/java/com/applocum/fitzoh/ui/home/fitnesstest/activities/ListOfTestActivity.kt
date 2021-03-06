package com.applocum.fitzoh.ui.home.fitnesstest.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.fitnesstest.adapters.RecyclerAdapterListOfTest
import com.applocum.fitzoh.ui.home.fitnesstest.models.ListOfTest
import kotlinx.android.synthetic.main.activity_list_of_test.*

class ListOfTestActivity : AppCompatActivity() {

    var mList:ArrayList<ListOfTest> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_test)

        ivBack.setOnClickListener {
            finish()
        }

        val dbhelper=Dbhelper(this)

        mList=dbhelper.getfitnesslist()
        rvListOfTest.layoutManager= GridLayoutManager(this,2)
        rvListOfTest.adapter=
            RecyclerAdapterListOfTest(
                this,
                mList,
                object :
                    RecyclerAdapterListOfTest.CellClickListener {
                    override fun onCellClickistener(myobject: ListOfTest, position: Int) {
                        val intent =
                            Intent(this@ListOfTestActivity, TestDetailsActivity::class.java)
                        intent.putExtra("listoftest", myobject)
                        intent.putExtra("position", position)
                        startActivity(intent)
                    }
                })
    }
}