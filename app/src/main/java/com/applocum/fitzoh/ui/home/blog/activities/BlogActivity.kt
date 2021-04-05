package com.applocum.fitzoh.ui.home.blog.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.blog.models.Blog
import com.bumptech.glide.Glide
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.activity_blog.*
import kotlinx.android.synthetic.main.activity_goal_setting.ivBack
import kotlinx.android.synthetic.main.custom_youtube_video.*

class BlogActivity : AppCompatActivity() {
    private var currentposition=0
    var blog: Blog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blog)

        ivBack.setOnClickListener {
            finish()
        }

        blog = intent.getSerializableExtra("blog") as Blog?
        currentposition= intent.getIntExtra("position",0)

        tvBlogabout.text=blog?.bDescription
        tvLevel.text=blog?.bLevel
        Glide.with(this).load(blog?.bImage).into(ivvideo)

        ivvideo.setOnClickListener {
            ivplay.visibility=View.GONE
            val metrics: DisplayMetrics = this.resources.displayMetrics

            val width = metrics.widthPixels
            val height = metrics.heightPixels

            val dialog = Dialog(this)
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_youtube_video)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    youTubePlayer.loadVideo(blog!!.bVideo, 0f)
                }
            })
            dialog.ivCancel.setOnClickListener {
                ivplay.visibility=View.VISIBLE
                dialog.dismiss()
            }
            dialog.show()
        }
    }
}