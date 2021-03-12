package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterListOfTest
import com.applocum.fitzoh.ui.home.models.ListOfTest
import kotlinx.android.synthetic.main.activity_list_of_test.*

class ListOfTestActivity : AppCompatActivity() {

    var mList:ArrayList<ListOfTest> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_test)

        ivBack.setOnClickListener {
            finish()
        }
        val ListOfTest1= ListOfTest(
            "Respiratory & Stamina",
            R.drawable.image_respirateryandstamina,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        val ListOfTest2= ListOfTest(
            "Cardiovasular Endurance",
            R.drawable.image_cardiovasularendurance,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        val ListOfTest3= ListOfTest(
            "Strength - Upper Body",
            R.drawable.image_strength_upperbody,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        val ListOfTest4= ListOfTest(
            "Strength - Lower Body",
            R.drawable.image_strength_lowerbody,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        val ListOfTest5= ListOfTest(
            "Flexibility",
            R.drawable.image_flexibility,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        val ListOfTest6= ListOfTest(
            "Power & Speed",
            R.drawable.image_powerandspeed,
            "Lorem ipsum dolor sit amet, cons ectetur adipiscing elit."
        )
        mList.add(ListOfTest1)
        mList.add(ListOfTest2)
        mList.add(ListOfTest3)
        mList.add(ListOfTest4)
        mList.add(ListOfTest5)
        mList.add(ListOfTest6)
        rvListOfTest.layoutManager= GridLayoutManager(this,2)
        rvListOfTest.adapter=
            RecyclerAdapterListOfTest(
                this,
                mList,
                object :
                    RecyclerAdapterListOfTest.CellClickListener {
                    override fun onCellClickistener(myobject: ListOfTest, position: Int) {
                        val intent = Intent(
                            this@ListOfTestActivity,
                            TestDetailsActivity::class.java
                        )
                        intent.putExtra("music", myobject)
                        intent.putExtra("position", position)
                        startActivity(intent)
                    }

                })


    }
}