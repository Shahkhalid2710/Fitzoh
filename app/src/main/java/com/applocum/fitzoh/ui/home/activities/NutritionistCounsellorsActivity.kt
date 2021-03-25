package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterNutritionists
import com.applocum.fitzoh.ui.home.models.Blog
import com.applocum.fitzoh.ui.home.models.Counsellor
import com.applocum.fitzoh.ui.home.models.Trainer
import kotlinx.android.synthetic.main.activity_nutritionist_counsellors.*

class NutritionistCounsellorsActivity : AppCompatActivity() {
     var mListAllNutritionists:ArrayList<Counsellor> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutritionist_counsellors)

        ivBack.setOnClickListener {
            finish()
        }
        val dbhelper=Dbhelper(this)
        mListAllNutritionists=dbhelper.getallCounselloers()

        rvNutritionist.layoutManager=LinearLayoutManager(this)
        rvNutritionist.adapter=RecyclerAdapterNutritionists(this,mListAllNutritionists)



    }
}