package com.applocum.fitzoh.ui.home.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterWorkout
import com.applocum.fitzoh.ui.home.models.Workout
import kotlinx.android.synthetic.main.activity_check_work_out.*

class CheckWorkOutActivity : AppCompatActivity() {
    private var mListworkout:ArrayList<Workout> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_work_out)
        ivBack.setOnClickListener {
            finish()
        }

        val dbhelper=Dbhelper(this)
        mListworkout=dbhelper.getworkout()

        rvWorkout.layoutManager=LinearLayoutManager(this)
        rvWorkout.adapter= RecyclerAdapterWorkout(this,mListworkout,object :RecyclerAdapterWorkout.CellClickListener
        {
            override fun onCellClickistener(myobject: Workout, position: Int) {

            }
        })

        btnSubmit.setOnClickListener {
            for (workout in mListworkout)
            {
                dbhelper.updateworkout(workout)
                finish()
                val homeScreenFragment=HomeScreenFragment()
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(R.id.llworkout,homeScreenFragment )
                transaction.commit()
            }
        }


        cbSelectall.setOnClickListener {
         if (cbSelectall.isChecked)
          {
           for (workout in mListworkout)
               workout.wStatus=1
          }
            else
          {
              for (workout in mListworkout)
                  workout.wStatus=0
          }
           val recyclerAdapterWorkout=RecyclerAdapterWorkout(this,mListworkout,object :RecyclerAdapterWorkout.CellClickListener{
               override fun onCellClickistener(myobject: Workout, position: Int) {

               }
           })
            recyclerAdapterWorkout.notifyDataSetChanged()
    }
    }
}