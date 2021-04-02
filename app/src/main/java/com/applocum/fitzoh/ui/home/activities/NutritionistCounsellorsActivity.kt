package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterNutritionists
import com.applocum.fitzoh.ui.home.models.Counsellor
import com.applocum.fitzoh.ui.home.models.Packages
import kotlinx.android.synthetic.main.activity_nutritionist_counsellors.*

class NutritionistCounsellorsActivity : AppCompatActivity() {
     private var mListAllNutritionists:ArrayList<Counsellor> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutritionist_counsellors)

        ivBack.setOnClickListener {
            finish()
        }
        val packages=intent.getSerializableExtra("packages") as Packages
        val dbhelper=Dbhelper(this)
        mListAllNutritionists=dbhelper.getallCounselloers()

        rvNutritionist.layoutManager=LinearLayoutManager(this)
        rvNutritionist.adapter=RecyclerAdapterNutritionists(this,mListAllNutritionists,object :RecyclerAdapterNutritionists.CellClickListener{
            override fun onCellClickistener(myobject: Counsellor, position: Int) {
                val intent= Intent(this@NutritionistCounsellorsActivity,CounsellorActivity::class.java)
                intent.putExtra("counsellor",myobject)
                intent.putExtra("position",position)
                intent.putExtra("packages",packages)
                startActivity(intent)
            }
        })

    }
}