package com.applocum.fitzoh.ui.goal.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.ui.bottomnavigation.activities.HomeActivity
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.goal.models.Goal
import com.applocum.fitzoh.ui.otpscreen.activities.OTPActivity
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_goal_setting.*
import java.lang.Integer.valueOf

class GoalSettingActivity : AppCompatActivity(), View.OnClickListener, PopupMenu.OnMenuItemClickListener {
    private var selectPositiveHabit:String = ""
    private lateinit var goal: Goal

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal_setting)
        calculateBMI()
        val dbhelper = Dbhelper(this)
        tvkg.text = "" + minrange() + "-" + maxrange() + "kg"
        ivBack.setOnClickListener {
            startActivity(Intent(this, OTPActivity::class.java))
        }
        etSelectFitnessgoal.setOnClickListener(this)

        ivPlus.setOnClickListener {
            increaseInteger()
        }
        ivMinus.setOnClickListener {
            decreaseInteger()
        }

        cbWakeup.setOnCheckedChangeListener { _, b ->
            if (b) {
                selectPositiveHabit ="Develop a consistent wake-up routine"
                cbSelfConfidence.isChecked = false
                cbSickness.isChecked = false
            }
        }
        cbSelfConfidence.setOnCheckedChangeListener { _, b ->
            if (b) {
                selectPositiveHabit ="Develop self confidence"
                cbWakeup.isChecked = false
                cbSickness.isChecked = false
            }
        }
        cbSickness.setOnCheckedChangeListener { _, b ->
            if (b) {
                selectPositiveHabit ="Sickness hygiene"
                cbWakeup.isChecked = false
                cbSelfConfidence.isChecked = false
            }
        }

        btnCommit.setOnClickListener {
          goal= Goal(
              tvBmi.text.toString(),
              tvOverWeight.text.toString(),
              tvkg.text.toString(),
              etKg.text.toString(),
              etSelectFitnessgoal.text.toString(),
              selectPositiveHabit
          )

            val userBmi:String=tvBmi.text.toString()
            val userbmitype:String=tvOverWeight.text.toString()
            val userweightrange=tvkg.text.toString()
            val usertargetweight=etKg.text.toString()
            val userfitnessgoaltime=etSelectFitnessgoal.text.toString()

            if (validategoal(userBmi,userbmitype,userweightrange,usertargetweight,userfitnessgoaltime,selectPositiveHabit))
            {
                dbhelper.goal(goal)
                FancyToast.makeText(this, "Commit", FancyToast.LENGTH_LONG, FancyToast.WARNING, false).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                this.startActivity(intent)
            }
        }
    }

    override fun onClick(v: View?) {
        val popupMenu = PopupMenu(this, etSelectFitnessgoal)
        popupMenu.menuInflater.inflate(
            R.menu.custom_menu_goal_level,
            popupMenu.menu
        )
        popupMenu.setOnMenuItemClickListener(this)
        popupMenu.show()
    }

    @SuppressLint("SetTextI18n")
    override fun onMenuItemClick(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.i_30mins -> etSelectFitnessgoal.setText("30 mins")
            R.id.i_60mins -> etSelectFitnessgoal.setText("60 mins")
            R.id.i_90mins -> etSelectFitnessgoal.setText("90 mins")
            R.id.i_120mins -> etSelectFitnessgoal.setText("120 mins")
            R.id.i_150mins -> etSelectFitnessgoal.setText("150 mins")
            else -> Toast.makeText(this, "Error", Toast.LENGTH_LONG).show()
        }
        return true
    }

    private fun increaseInteger() {
        display(etKg.text.toString().toInt() + 1)
    }

    private fun decreaseInteger() {
        display(etKg.text.toString().toInt() - 1)
    }

    private fun display(number: Int) {
        etKg.setText("$number")
    }

    private fun calculateBMI() {
        val height = intent.getStringExtra("height")
        val weight = intent.getStringExtra("weight")

        if (height != null && "" != height
            && weight != null && "" != weight
        ) {
            val heightValue = height.toFloat() / 100
            val weightValue = weight.toFloat()
            val bmi = weightValue / (heightValue * heightValue)
            displayBMI(bmi)
        }
    }

    private fun maxrange(): Int {
        val height: Int? = intent.getStringExtra("height")?.toInt()

        val a = height?.times(0.15)
        val sum = a?.plus(height)
        val kg = sum?.times(0.453592)
        return  valueOf(kg!!.toInt())
    }

    private fun minrange(): Int {
        val height = intent.getStringExtra("height")?.toInt()
        val a = height?.times(0.15)
        val sum = a?.let { height.minus(it) }
        val kg = sum?.times(0.453592)
        return valueOf(kg!!.toInt())
    }

    private fun displayBMI(bmi: Float) {
       val bmiLabel = if (bmi.compareTo(15f) <= 0) {
            getString(R.string.very_severely_underweight)
        } else if (bmi.compareTo(15f) > 0 && bmi.compareTo(16f) <= 0
        ) {
            getString(R.string.severely_underweight)

        } else if (bmi.compareTo(16f) > 0 && bmi.compareTo(18.5f) <= 0
        ) {
            getString(R.string.underweight)

        } else if (bmi.compareTo(18.5f) > 0 && bmi.compareTo(25f) <= 0
        ) {
            getString(R.string.normal)

        } else if (bmi.compareTo(25f) > 0 && bmi.compareTo(30f) <= 0
        ) {
            getString(R.string._overweight)

        } else if (bmi.compareTo(30f) > 0 && bmi.compareTo(35f) <= 0
        ) {
            getString(R.string.obese_class_i)

        } else if (bmi.compareTo(35f) > 0 && bmi.compareTo(40f) <= 0
        ) {
            getString(R.string.obese_class_ii)

        } else {
            getString(R.string.obese_class_iii)
        }
        tvBmi.text = "$bmi"
        tvOverWeight.text = bmiLabel
    }

    private fun validategoal(bmi:String, bmitype:String, weightrange:String, targetweight:String, fitnessgoal:String, positivehabit:String):Boolean
    {
        if (bmi.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please enter bmi", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (bmitype.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please enter bmitype", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (weightrange.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please enter weight range", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (targetweight.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please enter target weight", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (fitnessgoal.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please select fitnessgoal time", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (positivehabit.isEmpty()) {
            val snackbar = Snackbar.make(myLayout, "Please select positive habit", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
     return true
    }
}