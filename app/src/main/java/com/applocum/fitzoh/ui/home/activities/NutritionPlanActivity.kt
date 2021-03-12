package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterNutritionplan
import com.applocum.fitzoh.ui.home.models.NutritionPlan
import kotlinx.android.synthetic.main.activity_nutrition_plan.*
import kotlinx.android.synthetic.main.activity_select_plan.*
import kotlinx.android.synthetic.main.activity_select_plan.ivBack

class NutritionPlanActivity : AppCompatActivity() {
    var mList:ArrayList<NutritionPlan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_plan)
        ivBack.setOnClickListener {
            finish()
        }
        val nutritionplan1=NutritionPlan("Break Fast - 08:30 am","Calories: 35 | Protein: 3gm | Carbs: 5gm | Fat: 10gm")
        val nutritionplan2=NutritionPlan("Lunch - 12:30 pm","Calories: 35 | Protein: 3gm | Carbs: 5gm | Fat: 10gm")
        val nutritionplan3=NutritionPlan("Sancks - 04:15 pm","Calories: 35 | Protein: 3gm | Carbs: 5gm | Fat: 10gm")
        val nutritionplan4=NutritionPlan("Dinner - 09:45 pm","Calories: 35 | Protein: 3gm | Carbs: 5gm | Fat: 10gm")

        mList.add(nutritionplan1)
        mList.add(nutritionplan2)
        mList.add(nutritionplan3)
        mList.add(nutritionplan4)

        rvNutritionplan.layoutManager=LinearLayoutManager(this)
        rvNutritionplan.adapter=RecyclerAdapterNutritionplan(this,mList)
    }
}