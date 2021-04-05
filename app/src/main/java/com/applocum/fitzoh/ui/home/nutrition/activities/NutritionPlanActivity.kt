package com.applocum.fitzoh.ui.home.nutrition.activities

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.nutrition.adapters.RecyclerAdapterNutritionplan
import com.applocum.fitzoh.ui.home.nutrition.models.NutritionMeal
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_nutrition_plan.*
import kotlinx.android.synthetic.main.activity_select_plan.ivBack
import kotlinx.android.synthetic.main.custom_filter_layout_xml.view.btnCancel
import kotlinx.android.synthetic.main.custom_meal_layout.view.*


class NutritionPlanActivity : AppCompatActivity() {
    var mList = ArrayList<NutritionMeal>()
    private var mListnew:ArrayList<NutritionMeal> = ArrayList()
    private lateinit var nutritionMeal: NutritionMeal
    private lateinit var recyclerAdapterNutritionplan: RecyclerAdapterNutritionplan

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nutrition_plan)
        val dbhelper=Dbhelper(this)

        ivBack.setOnClickListener {
            finish()
        }


        btnAddMeal.setOnClickListener {
            val showDialogView= LayoutInflater.from(this).inflate(R.layout.custom_meal_layout,null,false)
            val dialog = AlertDialog.Builder(this).create()
            dialog.setView(showDialogView)

            showDialogView.btnAdd.setOnClickListener {

                nutritionMeal=
                    NutritionMeal(
                        showDialogView.etMealname.text.toString(),
                        showDialogView.etMealtime.text.toString()
                    )
                val mealname=showDialogView.etMealname.text.toString()
                val mealtime=showDialogView.etMealtime.text.toString()

                if (validateMeal(mealname, mealtime)) {
                    dbhelper.nutritionMeal(nutritionMeal)
                    Toast.makeText(this, "Successfully Add", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                    val refresh=intent
                    this.finish()
                    startActivity(refresh)
                }
            }
            showDialogView.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

        mList=dbhelper.getNutritionMeal()
        mListnew= dbhelper.getAllNutritionMeal()
        rvNutritionplan.layoutManager=LinearLayoutManager(this)
        recyclerAdapterNutritionplan=
            RecyclerAdapterNutritionplan(
                this,
                mListnew,
                object :
                    RecyclerAdapterNutritionplan.CellClickListener {
                    override fun onCellClickistener(myobject: NutritionMeal, position: Int) {
                        dbhelper.deletenutritionmeal(myobject.id)
                        mListnew.removeAt(position)
                        recyclerAdapterNutritionplan.notifyDataSetChanged()

                    }
                })
        rvNutritionplan.adapter=recyclerAdapterNutritionplan
        recyclerAdapterNutritionplan.notifyDataSetChanged()

    }
    private fun validateMeal(mealname:String, mealtime:String):Boolean
    {
     if (mealname.isEmpty())
     {
         val snackbar = Snackbar.make(nutritionlayout, "Please enter meal name", Snackbar.LENGTH_LONG)
         snackbar.show()
         return false
     }
        if (mealtime.isEmpty())
        {
            val snackbar = Snackbar.make(nutritionlayout, "Please enter meal time", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
     return true
    }
}