package com.applocum.fitzoh.ui.signin.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.ui.otpscreen.activities.OTPActivity
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.signup.activities.SignUpActivity
import com.google.android.material.snackbar.Snackbar
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.linearlayout
import java.lang.String.format
import java.util.*
import java.util.regex.Pattern

class SignInActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    private val emailPattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )

    @SuppressLint("DefaultLocale")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val dbhelper = Dbhelper(this)
        val x= intent.getStringExtra("height")
        val y= intent.getStringExtra("weight")
        tvsignup.setOnClickListener {
            val intent=Intent(this,
                SignUpActivity::class.java)
            startActivity(intent)
        }

        btnContinue.setOnClickListener {

            val email=etEmailNo.text.toString()

            if (checkemail(email)) {
                val random = Random()
                val generatedPassword = format("%04d", random.nextInt(10000))


                val user = dbhelper.signin(email)

                Log.d("EMaillll","---->--"+user?.userEmail.isNullOrBlank())
                Log.d("EMaillll","---->"+user?.userEmail.isNullOrEmpty())
                if (user?.userEmail.isNullOrEmpty()) {
                    FancyToast.makeText(this, "Email don't match", FancyToast.LENGTH_LONG, FancyToast.WARNING, false).show()

                } else
                {
                    sharedPreferences=getSharedPreferences("mypref", MODE_PRIVATE)
                    editor=sharedPreferences.edit()
                    if (user != null) {
                        editor.putString("email",user.userEmail)
                        editor.putInt("id",user.id)
                    }
                    editor.apply()
                    editor.commit()


                    FancyToast.makeText(this, "Successful", FancyToast.LENGTH_LONG, FancyToast.WARNING, false).show()
                    val intent = Intent(this, OTPActivity::class.java)
                    intent.putExtra("digit",generatedPassword)
                    intent.putExtra("height",x)
                    intent.putExtra("weight",y)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                    this.startActivity(intent)
                    finish()


                }
            }

        }
    }
    private fun checkemail(useremail:String):Boolean
    {
        if (useremail.isEmpty()) {
            val snackbar = Snackbar.make(linearlayout, "Please enter email", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
       if (!emailPattern.matcher(useremail).matches()) {
            val snackbar = Snackbar.make(linearlayout, "Invalid Email", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }

        return true
    }


}