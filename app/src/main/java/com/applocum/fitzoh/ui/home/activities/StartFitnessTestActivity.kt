package com.applocum.fitzoh.ui.home.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.models.FitnessTest
import com.applocum.fitzoh.ui.home.models.ListOfTest
import com.google.android.material.snackbar.Snackbar
import com.triggertrap.seekarc.SeekArc
import kotlinx.android.synthetic.main.activity_start_fitness_test.*

class StartFitnessTestActivity : AppCompatActivity(), SeekArc.OnSeekArcChangeListener {

    lateinit var fitnessTest: FitnessTest
    lateinit var listOfTest:ListOfTest
    var starttime:Long=0

    val timehandler=Handler()
    val timerRunnable: Runnable = object : Runnable {
        override fun run() {
            val millis: Long = System.currentTimeMillis() - starttime
            var seconds = (millis / 1000).toInt()
            val minutes = seconds /60
            seconds = seconds % 60
            tvtime.setText(String.format("%d:%02d", minutes, seconds))
            seekArc.setProgress(seconds)

            timehandler.postDelayed(this, 1000)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_fitness_test)
        seekArc.setOnSeekArcChangeListener(this)

        btnStart.setOnClickListener {
         //   btnStart.visibility=View.GONE
        //    btnStop.visibility=View.VISIBLE
            timehandler.removeCallbacks(timerRunnable)

            if (btnStart.getText().equals("stop")) {
                timehandler.removeCallbacks(timerRunnable)
                btnStart.setText("start")
            } else {
                starttime = System.currentTimeMillis()
                timehandler.postDelayed(timerRunnable, 0)
                btnStart.setText("stop")
            }
        }


        val dbhelper=Dbhelper(this)
        ivBack.setOnClickListener {
            finish()
        }
        etSelectResult.setOnClickListener {
            selectResult()
        }




        listOfTest= intent.getSerializableExtra("listoftest") as ListOfTest
         val mydate: String = intent.getStringExtra("selecteddate").toString()
        Log.d("mydate","->"+mydate)

        btnSubmit.setOnClickListener {
            fitnessTest= FitnessTest(mydate.toString(),tvtime.text.toString(),etSelectResult.text.toString(),etComment.text.toString())
            val time:String=tvtime.text.toString()
            val result= etSelectResult.text.toString()
            val comment=etComment.text.toString()


            if (validateTest(mydate,time, result, comment))
            {
                dbhelper.fitnesstest(fitnessTest,listOfTest.id)
                Log.d("idmy","->"+listOfTest.id)

                val myToast = Toast.makeText(applicationContext,"Successfully Completed",Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.CENTER,0,0)
                myToast.show()
                val intent = Intent(this, TestDetailsActivity::class.java)
                intent.putExtra("fitnesstest",fitnessTest)
                this.startActivity(intent)
            }
        }
    }

    private fun selectResult() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Choose Result")

        val lables: MutableList<String> = ArrayList()
        lables.add("Upto Knee")
        lables.add("Upto Shine")
        lables.add("Upto Ankle")
        lables.add("Toe Touch")
        lables.add("Toe Hold")
        lables.add("1 Palm ahead of Toe")

        val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
        builder.setAdapter(dataAdapter) { _, which ->
            //    Toast.makeText(this, "" + lables[which], Toast.LENGTH_LONG).show()
            etSelectResult.setText(lables[which]).toString()
        }
        val dialog = builder.create()
        dialog.show()
    }
     fun validateTest(date:String,time:String,result:String,comment:String):Boolean
     {
         if (time.isEmpty()) {
             val snackbar = Snackbar.make(testlayout, "Enter time", Snackbar.LENGTH_LONG)
             snackbar.show()
             return false
         }
         if (result.isEmpty()) {
             val snackbar = Snackbar.make(testlayout, "Please select result", Snackbar.LENGTH_LONG)
             snackbar.show()
             return false
         }
         if (comment.isEmpty()) {
             val snackbar = Snackbar.make(testlayout, "Please enter comment", Snackbar.LENGTH_LONG)
             snackbar.show()
             return false
         }
         return true
     }

    override fun onProgressChanged(seekArc: SeekArc?, progress: Int, fromUser: Boolean) {

    }

    override fun onStartTrackingTouch(seekArc: SeekArc?) {

    }

    override fun onStopTrackingTouch(seekArc: SeekArc?) {

    }

}