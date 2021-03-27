package com.applocum.fitzoh.ui.home.activities

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.NutritionMeal
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_food_item.*
import java.util.ArrayList

class AddFoodItemActivity : AppCompatActivity(), AdapterView.OnItemClickListener {
    private var seletedfood:String=""
    private lateinit var nutritionMeal:NutritionMeal
    private lateinit var nutritionMeal2:NutritionMeal
    private var language = arrayOf("Roti","Kiwi fruit", "Dosa", "Ice-Cream","Chai","Rice", "Chicken", "Chocolate", "Boiled Egg", "Milk","Bread","Aloo ka paratha","Idli")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_food_item)
        ivBack.setOnClickListener {
            finish()
        }
        val dbhelper=Dbhelper(this)
        nutritionMeal= intent.getSerializableExtra("nutritionMeal") as NutritionMeal

        btnAddItem.setOnClickListener {
            val name=nutritionMeal.nName
            val time=nutritionMeal.nTime
            nutritionMeal2= NutritionMeal(name,time,seletedfood,etNoofServing.text.toString(),etServingSize.text.toString())
            val foodname=seletedfood
            val noofserving=etNoofServing.text.toString()
            val servingsize=etServingSize.text.toString()

            if (validatefooddata(nutritionMeal.nName,nutritionMeal.nTime,foodname, noofserving, servingsize))
            {
                val id=nutritionMeal.id
                dbhelper.updatenutritionMeal(nutritionMeal2,id)
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NutritionPlanActivity::class.java)
                intent.putExtra("nutritionMeal2",nutritionMeal2)
                this.startActivity(intent)
            }
        }
        etNoofServing.setOnClickListener {
            selectnoofserving()
        }
        etServingSize.setOnClickListener {
            selectservingsize()
        }
         val adapterACTV=ArrayAdapter(this,android.R.layout.simple_list_item_1,language)
        actv.threshold = 1
        actv.setAdapter(adapterACTV)
        actv.setTextColor(Color.BLACK)
        actv.onItemClickListener = this
    }
    private fun selectnoofserving() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Serving")

        val lables: MutableList<String> = ArrayList()
        lables.add("1.0")
        lables.add("1.5")
        lables.add("2.0")
        lables.add("2.5")
        lables.add("3.0")
        lables.add("3.5")
        lables.add("4.0")
        lables.add("4.5")
        lables.add("5.0")
        lables.add("5.5")
        lables.add("6.0")
        lables.add("6.5")
        lables.add("7.0")
        lables.add("7.5")
        lables.add("8.0")
        lables.add("8.5")
        lables.add("9.0")
        lables.add("9.5")
        lables.add("10.0")
        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            etNoofServing.setText(lables[which]).toString()
        }

        val dialog = builder.create()
        dialog.show()
    }
    private fun selectservingsize() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Serving Size")

        val lables: MutableList<String> = ArrayList()
        lables.add("1 piece")
        lables.add("2 piece")
        lables.add("3 piece")
        lables.add("4 piece")
        lables.add("5 piece")
        lables.add("6 piece")
        lables.add("7 piece")
        lables.add("8 piece")
        lables.add("9 piece")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            etServingSize.setText(lables[which]).toString()
        }

        val dialog = builder.create()
        dialog.show()
    }

    override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        seletedfood=actv.text.toString()
    }


    private fun validatefooddata(mealname:String, mealtime:String, foodname:String, noofserving:String, servingsize:String):Boolean
    {
        if (mealname.isEmpty()) {
            val snackbar = Snackbar.make(llfoodlayout, "Please enter mealname", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (mealtime.isEmpty()) {
            val snackbar = Snackbar.make(llfoodlayout, "Please enter mealtime", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (foodname.isEmpty()) {
            val snackbar = Snackbar.make(llfoodlayout, "Please select foodname", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (noofserving.isEmpty()) {
            val snackbar = Snackbar.make(llfoodlayout, "Please select serving", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (servingsize.isEmpty()) {
            val snackbar = Snackbar.make(llfoodlayout, "Please select serving size", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        return true
    }
}