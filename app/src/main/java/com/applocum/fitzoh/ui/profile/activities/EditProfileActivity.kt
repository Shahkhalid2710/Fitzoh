package com.applocum.fitzoh.ui.profile.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.DatePicker
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.signup.models.User
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.activity_edit_profile.etDOB
import kotlinx.android.synthetic.main.activity_edit_profile.etdailyactivity
import kotlinx.android.synthetic.main.activity_edit_profile.etgender
import kotlinx.android.synthetic.main.activity_edit_profile.etheight
import kotlinx.android.synthetic.main.activity_edit_profile.etmealType
import kotlinx.android.synthetic.main.activity_edit_profile.etusername
import kotlinx.android.synthetic.main.activity_edit_profile.etweight
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class EditProfileActivity : AppCompatActivity(),DatePickerDialog.OnDateSetListener {
    private lateinit var sharedPreferences: SharedPreferences
    private var day: Int = 0
    private var month: Int = 0
    private var year: Int = 0
    private var myDay: Int = 0
    private var myMonth: Int = 0
    private var myYear: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        ivBack.setOnClickListener {
            finish()
        }

        val dbhelper = Dbhelper(this)
        sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
        val email=sharedPreferences.getString("email","")
        val id=sharedPreferences.getInt("id",0)


        var user= email?.let { dbhelper.signin(it) }
        etusername.setText(user?.userName)
        etDOB.setText(user?.userDOB)
        etgender.setText(user?.userGender)
        etheight.setText(user?.userHeight)
        etweight.setText(user?.userWeight)
        etdailyactivity.setText(user?.dailyactivity)
        etmealType.setText(user?.mealtype)

        etDOB.setOnClickListener {
            val calendar: Calendar = Calendar.getInstance()
            this.day = calendar.get(Calendar.DAY_OF_MONTH)
            this.month = calendar.get(Calendar.MONTH)
            this.year = calendar.get(Calendar.YEAR)

            val datePickerDialog = DatePickerDialog(this, this, year, month, day)
            datePickerDialog.show()
        }
        etgender.setOnClickListener {
            selectgender()
        }
        etweight.setOnClickListener {
            selectweight()
        }
        etheight.setOnClickListener {
            selectheight()
        }
        etmealType.setOnClickListener {
            selectmealtype()
        }
        btnSubmit.setOnClickListener {
            user = User(
                etusername.text.toString(),
                email,
                user?.userMobileNumber,
                etDOB.text.toString(),
                etgender.text.toString(),
                etheight.text.toString(),
                etweight.text.toString(),
                etdailyactivity.text.toString(),
                etmealType.text.toString(),
                user?.userCurrentBodyFat
            )
            val username = etusername.text.toString()
            val userDOB = etDOB.text.toString()
            val usergender = etgender.text.toString()
            val userheight = etheight.text.toString()
            val userweight = etweight.text.toString()
            val userdailyactivity = etdailyactivity.text.toString()
            val usermealtype = etmealType.text.toString()
            if (validate(
                    username,
                    userDOB,
                    usergender,
                    userheight,
                    userweight,
                    userdailyactivity,
                    usermealtype
                )
            ) {

                dbhelper.updateprofile(user,id)
                Log.d("iddddmyyyy","-->"+id)
                FancyToast.makeText(
                    this,
                    "Successfully Update",
                    FancyToast.LENGTH_SHORT,
                    FancyToast.WARNING,
                    false
                ).show()

                etusername.setText(user?.userName)
                etDOB.setText(user?.userDOB)
                etgender.setText(user?.userGender)
                etheight.setText(user?.userHeight)
                etweight.setText(user?.userWeight)
                etdailyactivity.setText(user?.userdDailyActivity)
                etmealType.setText(user?.userMealType)
                finish()
                val profileFragment = ProfileFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.lleditprofile, profileFragment)
                transaction.commit()
            }
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
            etweight.setText(lables[which]).toString()
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
            etheight.setText(lables[which]).toString()
        }

        val dialog = builder.create()
        dialog.show()
    }

    private fun selectgender() {
        val options = arrayOf("Male", "Female")
        var selectedItem = 0
        val builder = AlertDialog.Builder(this,
            R.style.MyAlertDialogStyle
        )
        builder.setTitle("Choose Gender")
        builder.setSingleChoiceItems(options, 0) { _: DialogInterface, item: Int ->
            selectedItem = item
            etgender.setText(options[selectedItem])
        }
        builder.setPositiveButton("Ok") { dialogInterface: DialogInterface, _: Int ->
            //  Toast.makeText(this, "" + options[selectedItem], Toast.LENGTH_SHORT).show()
            etgender.setText(options[selectedItem])
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }
        builder.create()
        builder.show()
    }

    @SuppressLint("SimpleDateFormat")
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myYear = year
        myMonth = month
        myDay = dayOfMonth


        val date = "" + myDay + "-" + (myMonth + 1) + "- " + myYear
        var spf = SimpleDateFormat("dd-MM-yy")
        val newDate = spf.parse(date)
        spf = SimpleDateFormat("dd-MMMM-yyyy")
        val newDateString = spf.format(newDate)
        println(newDateString)
        etDOB.setText(newDateString)
    }
    private fun selectmealtype() {
        val options = arrayOf("Vegetarian", "Non-Vegetarian", "eggetarian", "Vegan")
        var selectedItem = 0
        val builder = AlertDialog.Builder(this,
            R.style.MyAlertDialogStyle
        )
        builder.setTitle("Choose Meal Type")
        builder.setSingleChoiceItems(options, 0) { _: DialogInterface, item: Int ->
            selectedItem = item
            etmealType.setText(options[selectedItem])
        }
        builder.setPositiveButton("Ok") { dialogInterface: DialogInterface, _: Int ->
            //   Toast.makeText(this, "" + options[selectedItem], Toast.LENGTH_SHORT).show()
            etmealType.setText(options[selectedItem])
            dialogInterface.dismiss()
        }
        builder.setNegativeButton("Cancel") { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
        }
        builder.create()
        builder.show()
    }
    private fun validate(
        name: String,
        date: String,
        gender: String,
        height: String,
        weight: String,
        dailyactivity: String,
        mealtype: String
    ): Boolean {
        if (name.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please enter username", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (date.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please select date", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (gender.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please select gender", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (height.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please select height", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (weight.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please select weight", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (dailyactivity.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please enter daily activity", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (mealtype.isEmpty()) {
            val snackbar = Snackbar.make(lleditprofile, "Please select meal type", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        return true
    }

}