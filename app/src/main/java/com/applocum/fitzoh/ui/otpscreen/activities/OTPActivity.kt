package com.applocum.fitzoh.ui.otpscreen.activities

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.applocum.fitzoh.ui.goal.activities.GoalSettingActivity
import com.applocum.fitzoh.R
import com.shashank.sony.fancytoastlib.FancyToast
import kotlinx.android.synthetic.main.activity_o_t_p.*

class OTPActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_o_t_p)
        val a = intent.getStringExtra("digit")
        val p= intent.getStringExtra("height")
        val q= intent.getStringExtra("weight")

        if (a?.length == 4) {
            et1.setText("" + a[0])
            et2.setText("" + a[1])
            et3.setText("" + a[2])
            et4.setText("" + a[3])
        }
        btnVerify.setOnClickListener {

            if (!et1.text.isNullOrEmpty() && !et2.text.isNullOrEmpty() && !et3.text.isNullOrEmpty()&& !et4.text.isNullOrEmpty()) {
               val intent=Intent(this, GoalSettingActivity::class.java)
                intent.putExtra("height",p)
                intent.putExtra("weight",q)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
            }
            else
            {
                FancyToast.makeText(this, "Please check data", FancyToast.LENGTH_LONG, FancyToast.WARNING, false).show()
            }
        }
    }
}
