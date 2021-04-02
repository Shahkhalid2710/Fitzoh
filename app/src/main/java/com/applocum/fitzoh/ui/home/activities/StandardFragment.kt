package com.applocum.fitzoh.ui.home.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterBasicPackages
import com.applocum.fitzoh.ui.home.models.Packages
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.custom_xml.ivCancel
import kotlinx.android.synthetic.main.custom_youtube_video.*
import kotlinx.android.synthetic.main.fragment_standard.view.*
import kotlinx.android.synthetic.main.fragment_standard.view.ivvideo

class StandardFragment : Fragment() {
    private var mListPackages:ArrayList<Packages> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val v= inflater.inflate(R.layout.fragment_standard, container, false)
        val dbhelper= activity?.let { Dbhelper(it) }
        mListPackages=dbhelper!!.getstandardpackage()
        v.rvStandardPackage.layoutManager= LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        v.rvStandardPackage.adapter= activity?.let { RecyclerAdapterBasicPackages(it,mListPackages,object :RecyclerAdapterBasicPackages.CellClickListener{
            override fun onCellClickistener(myobject: Packages, position: Int) {
                val intent= Intent(activity,NutritionistCounsellorsActivity::class.java)
                intent.putExtra("packages",myobject)
                intent.putExtra("position",position)
                startActivity(intent)
            }
        }) }
        v.ivvideo.setOnClickListener {
             v.ivplayStop.visibility=View.GONE
             val metrics: DisplayMetrics = requireActivity().resources.displayMetrics
             val width = metrics.widthPixels
             val height = metrics.heightPixels

            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setContentView(R.layout.custom_youtube_video)
            dialog.window!!.setLayout(width, height)
            dialog.window?.setBackgroundDrawableResource(R.color.tp)

            dialog.youtube_player_view.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = "UBMk30rjy0o"
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })

            dialog.ivCancel.setOnClickListener {
                v.ivplayStop.visibility=View.VISIBLE
                dialog.cancel()
            }

            dialog.show()
        }
        return v
    }
    }
