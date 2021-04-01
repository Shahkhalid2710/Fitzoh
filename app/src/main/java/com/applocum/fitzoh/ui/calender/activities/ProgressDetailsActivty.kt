package com.applocum.fitzoh.ui.calender.activities

import android.app.AlertDialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.calender.models.Progress
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_about_trainer.ivBack
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_progress_details_activty.*
import kotlinx.android.synthetic.main.activity_progress_details_activty.btnSubmit
import java.util.ArrayList

class ProgressDetailsActivty : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var progress: Progress
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress_details_activty)
        val dbhelper=Dbhelper(this)
        sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
        val id=sharedPreferences.getInt("id",0)
        ivBack.setOnClickListener {
            finish()
        }

        progress= intent.getSerializableExtra("progress") as Progress
        val weight=progress.uWeight
        val height=progress.uHeight
        val bodyfat=progress.uBodyfat
        val chest=progress.uChest
        val arm=progress.uArm

        etWeight.setText(weight)
        etHeight.setText(height)
        etbodyfat.setText(bodyfat)
        etChest.setText(chest)
        etArm.setText(arm)

        etWeight.setOnClickListener {
            selectweight()
        }
        etHeight.setOnClickListener {
            selectheight()
        }
        etbodyfat.setOnClickListener {
            selectbodyfat()
        }
        etChest.setOnClickListener {
            selectChest()
        }
        etArm.setOnClickListener {
            selectArm()
        }



        btnSubmit.setOnClickListener {
            val progress=Progress(etHeight.text.toString(),etHeight.text.toString(),etbodyfat.text.toString(),etChest.text.toString(),etArm.text.toString())
            dbhelper.progress(progress,id)
            val snackbar = Snackbar.make(llprogress, "Succesfully update", Snackbar.LENGTH_LONG)
            snackbar.show()
            finish()
            /*val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.llprogress,CalenderFragment())
            transaction.commit()*/
        }
    }
    private fun selectweight() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Weight")

        val lables: MutableList<String> = ArrayList()
        lables.add("50")
        lables.add("51")
        lables.add("52")
        lables.add("53")
        lables.add("54")
        lables.add("55")
        lables.add("56")
        lables.add("56")
        lables.add("57")
        lables.add("58")
        lables.add("59")
        lables.add("60")
        lables.add("61")
        lables.add("62")
        lables.add("63")
        lables.add("64")
        lables.add("65")
        lables.add("66")
        lables.add("67")
        lables.add("68")
        lables.add("69")
        lables.add("70")
        lables.add("71")
        lables.add("72")
        lables.add("73")
        lables.add("74")
        lables.add("75")
        lables.add("78")
        lables.add("79")
        lables.add("80")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //    Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etWeight.setText(lables[which]).toString()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun selectbodyfat() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Weight")

        val lables: MutableList<String> = ArrayList()
        lables.add("15")
        lables.add("16")
        lables.add("17")
        lables.add("18")
        lables.add("19")
        lables.add("20")
        lables.add("21")
        lables.add("22")
        lables.add("23")
        lables.add("24")
        lables.add("25")
        lables.add("26")
        lables.add("27")
        lables.add("28")
        lables.add("29")
        lables.add("30")
        lables.add("31")
        lables.add("32")
        lables.add("33")
        lables.add("34")
        lables.add("35")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //    Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etbodyfat.setText(lables[which]).toString()
        }
        val dialog = builder.create()
        dialog.show()
    }

    private fun selectChest() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Weight")

        val lables: MutableList<String> = ArrayList()
        lables.add("15")
        lables.add("16")
        lables.add("17")
        lables.add("18")
        lables.add("19")
        lables.add("20")
        lables.add("21")
        lables.add("22")
        lables.add("23")
        lables.add("24")
        lables.add("25")
        lables.add("26")
        lables.add("27")
        lables.add("28")
        lables.add("29")
        lables.add("30")
        lables.add("31")
        lables.add("32")
        lables.add("33")
        lables.add("34")
        lables.add("35")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //    Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etChest.setText(lables[which]).toString()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun selectArm() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Weight")

        val lables: MutableList<String> = ArrayList()
        lables.add("8")
        lables.add("9")
        lables.add("10")
        lables.add("11")
        lables.add("12")
        lables.add("13")
        lables.add("14")
        lables.add("15")
        lables.add("16")
        lables.add("17")
        lables.add("18")
        lables.add("19")
        lables.add("20")
        lables.add("21")
        lables.add("22")
        lables.add("23")
        lables.add("24")
        lables.add("25")


        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //    Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etArm.setText(lables[which]).toString()
        }
        val dialog = builder.create()
        dialog.show()
    }
    private fun selectheight() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Height")

        val lables: MutableList<String> = ArrayList()
        lables.add("170")
        lables.add("171")
        lables.add("172")
        lables.add("173")
        lables.add("174")
        lables.add("175")
        lables.add("176")
        lables.add("177")
        lables.add("178")
        lables.add("179")
        lables.add("180")
        lables.add("181")
        lables.add("182")
        lables.add("183")
        lables.add("184")
        lables.add("185")
        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //  Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etHeight.setText(lables[which]).toString()
        }

        val dialog = builder.create()
        dialog.show()
    }
}