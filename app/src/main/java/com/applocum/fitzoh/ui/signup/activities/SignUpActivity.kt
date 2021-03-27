package com.applocum.fitzoh.ui.signup.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.signin.activities.SignInActivity
import com.applocum.fitzoh.ui.signup.models.User
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.regex.Pattern


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SignUpActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener{
    private lateinit var user: User
    private var day: Int = 0
    private var month: Int = 0
    private var year: Int = 0
    private var myDay: Int = 0
    private var myMonth: Int = 0
    private var myYear: Int = 0
    private var selectbodyfat = ""
    private val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    private val MobilePattern =Pattern.compile("[0-9]{10}")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val dbhelper = Dbhelper(this)
        tvsignin.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            this.startActivity(intent)
        }

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
        etheight.setOnClickListener {
            selectheight()
        }
        etweight.setOnClickListener {
            selectweight()
        }
        etmealType.setOnClickListener {
            selectmealtype()
        }

        btnsignup.setOnClickListener {

            user = User(
                etusername.text.toString(),
                etemail.text.toString(),
                etMobileno.text.toString(),
                etDOB.text.toString(),
                etgender.text.toString(),
                etheight.text.toString(),
                etweight.text.toString(),
                etdailyactivity.text.toString(),
                etmealType.text.toString(),
                selectbodyfat
            )

            val username: String = etusername.text.toString()
            val useremail: String = etemail.text.toString().trim()
            val usermobileno: String = etMobileno.text.toString()
            val userDOB: String = etDOB.text.toString()
            val usergender: String = etgender.text.toString()
            val userheight: String = etheight.text.toString()
            val userweight: String = etweight.text.toString()
            val userdailyactivity: String = etdailyactivity.text.toString()
            val usermealtype: String = etmealType.text.toString()

            if (validate(
                    username,
                    useremail,
                    usermobileno,
                    userDOB,
                    usergender,
                    userheight,
                    userweight,
                    userdailyactivity,
                    usermealtype,selectbodyfat)
            ) {

                dbhelper.signup(user)
                FancyToast.makeText(this, "Successfully Signup", FancyToast.LENGTH_SHORT, FancyToast.WARNING, false).show()
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("height",userheight)
                intent.putExtra("weight",userweight)
                startActivity(intent)
            }
        }



       cb1.setOnCheckedChangeListener { _, b ->
           if (b) {
               selectbodyfat="1"
               cb2.isChecked = false
               cb3.isChecked = false
           }
       }
        cb2.setOnCheckedChangeListener { _, b ->
            if (b) {
                selectbodyfat="2"
                cb1.isChecked = false
                cb3.isChecked = false
            }
        }
        this.cb3.setOnCheckedChangeListener { _, b ->
            if (b) {
                selectbodyfat="3"
                cb2.isChecked = false
                cb1.isChecked = false
            }
        }
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

    private fun validate(
        name: String,
        email: String,
        mobileno: String,
        date: String,
        gender: String,
        height: String,
        weight: String,
        dailyactivity: String,
        mealtype: String,
        bodyfat:String
    ): Boolean {
        if (name.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please enter username", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (email.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please enter email", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (!emailPattern.matcher(email).matches()) {
            val snackbar = Snackbar.make(linearlayout, "Invalid Email", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (mobileno.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please enter mobile number", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (!MobilePattern.matcher(mobileno).matches()) {
            val snackbar = Snackbar.make(linearlayout, "Invalid Number", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (date.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please select date", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (gender.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please select gender", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (height.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please select height", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (weight.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please select weight", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (dailyactivity.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please enter daily activity", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (mealtype.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please select meal type", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (bodyfat.isEmpty())
        {
            val snackbar = Snackbar.make(linearlayout, "Please select body fat", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        return true
    }


}