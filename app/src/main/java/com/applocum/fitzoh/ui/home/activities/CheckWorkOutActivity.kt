package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterWorkout
import com.applocum.fitzoh.ui.home.models.Workout
import kotlinx.android.synthetic.main.activity_check_work_out.*

class CheckWorkOutActivity : AppCompatActivity() {
    var mListworkout:ArrayList<Workout> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_work_out)

        ivBack.setOnClickListener {
            finish()
        }
        val dbhelper=Dbhelper(this)
        mListworkout=dbhelper.getworkout()
        Log.d("nameeee","-->"+mListworkout)

        rvWorkout.layoutManager=LinearLayoutManager(this)
        rvWorkout.adapter=RecyclerAdapterWorkout(this,mListworkout,object :RecyclerAdapterWorkout.CellClickListener
        {
            override fun onCellClickistener(myobject: Workout, position: Int) {
               Log.d("positionnn","->"+myobject.id)
            }
        })
    }
    }