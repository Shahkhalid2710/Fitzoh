package com.applocum.fitzoh.ui.home.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterWorkout
import com.applocum.fitzoh.ui.home.models.Workout
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_check_work_out.*
import kotlinx.android.synthetic.main.custom_youtube_video.*

class CheckWorkOutActivity : AppCompatActivity() {
    private var mListworkout:ArrayList<Workout> = ArrayList()
    private lateinit var recyclerAdapterWorkout: RecyclerAdapterWorkout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_work_out)
        ivBack.setOnClickListener {
            finish()
        }

        val dbhelper=Dbhelper(this)
        mListworkout=dbhelper.getworkout()
        recyclerAdapterWorkout= RecyclerAdapterWorkout(this,mListworkout,object :RecyclerAdapterWorkout.CellClickListener{
            override fun onCellClickistener(myobject: Workout, position: Int) {
            }
        })

        for (workout in mListworkout)
            if (workout.wStatus == 1)
            {
                cbSelectall.isChecked=true
            }
          else
            {
                cbSelectall.isChecked=false
                break
            }

        rvWorkout.layoutManager=LinearLayoutManager(this)
        rvWorkout.adapter= recyclerAdapterWorkout

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
         if (cbSelectall.isChecked )
          {
           for (workout in mListworkout)
               workout.wStatus=1
              recyclerAdapterWorkout.notifyDataSetChanged()

          }
         else
          {
              for (workout in mListworkout)
                  workout.wStatus=0
              recyclerAdapterWorkout.notifyDataSetChanged()
          }


    }

        ivvideo.setOnClickListener {
            ivPlay.visibility=View.GONE
            val metrics: DisplayMetrics = this.resources.displayMetrics

            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_youtube_video)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            /*dialog.videoview.setVideoURI(Uri.parse(workout.wVideo))
            dialog.videoview.start()*/
            dialog.youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                      val videoId = "7KSNmziMqog"
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })

           dialog.ivCancel.setOnClickListener {
               ivPlay.visibility=View.VISIBLE
               dialog.dismiss()
           }
            dialog.show()
        }
    }
}