package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterNutritionists
import com.applocum.fitzoh.ui.home.models.Blog
import kotlinx.android.synthetic.main.activity_nutritionist_counsellors.*

class NutritionistCounsellorsActivity : AppCompatActivity() {
    var mListNutritionist:ArrayList<Blog> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutritionist_counsellors)

        ivBack.setOnClickListener {
            finish()
        }
        val blog1=Blog(R.drawable.ena.toString(),"Jenna Hopper","Experience: 05 years")
        val blog2=Blog(R.drawable.amelia.toString(),"Amelia Freer","Experience: 03 years")
        val blog3=Blog(R.drawable.enablatner.toString(),"Enaa blatner","Experience: 02 years")
        val blog4=Blog(R.drawable.bewell.toString(),"Bewell Bykelly","Experience: 02 years")

        mListNutritionist.add(blog1)
        mListNutritionist.add(blog2)
        mListNutritionist.add(blog3)
        mListNutritionist.add(blog4)

        rvNutritionist.layoutManager=LinearLayoutManager(this)
        rvNutritionist.adapter=RecyclerAdapterNutritionists(this,mListNutritionist)

    }
}