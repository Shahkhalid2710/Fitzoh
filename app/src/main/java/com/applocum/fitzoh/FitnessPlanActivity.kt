package com.applocum.fitzoh

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_fitness_plan.*

class FitnessPlanActivity : AppCompatActivity() {

    private var mList:ArrayList<Fitnessplan> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_plan)

        val fitnessplan1 =Fitnessplan(R.drawable.barbell_press,"Barbell Bench Press","05 rounds X 50 / 25 / 12 / 10 / 10")
        val fitnessplan2 =Fitnessplan(R.drawable.dumbell_press,"Dumbell Press","05 rounds X 10 / 10 / 10 / 10")
        val fitnessplan3 =Fitnessplan(R.drawable.dumbbell_bench_press,"How To: Dumbbell Chest Pre..","04 rounds X 6-8 6-8 6-8 6-8")
        val fitnessplan4 =Fitnessplan(R.drawable.dumbellfly,"Dubell Fly","04 rounds X 6-8 6-8 6-8 6-8")
        val fitnessplan5=Fitnessplan(R.drawable.cableflys,"Cable Flys","04 rounds X 6-8 6-8 6-8 6-8")

        mList.add(fitnessplan1)
        mList.add(fitnessplan2)
        mList.add(fitnessplan3)
        mList.add(fitnessplan4)
        mList.add(fitnessplan5)

        rvFitnessplan.layoutManager=LinearLayoutManager(this)
        rvFitnessplan.adapter=RecyclerAdapterfitnessplan(this,mList)
    }
}