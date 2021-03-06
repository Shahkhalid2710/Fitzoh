package com.applocum.fitzoh.ui.home.wholestichealthandwellness.premiumpackages.activities

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.wholestichealthandwellness.activities.NutritionistCounsellorsActivity
import com.applocum.fitzoh.ui.home.wholestichealthandwellness.adapters.RecyclerAdapterBasicPackages
import com.applocum.fitzoh.ui.home.wholestichealthandwellness.models.Packages
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import kotlinx.android.synthetic.main.custom_xml.ivCancel
import kotlinx.android.synthetic.main.custom_youtube_video.*
import kotlinx.android.synthetic.main.fragment_premium.view.*


class PremiumFragment : Fragment() {
    private var mListPackages:ArrayList<Packages> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v= inflater.inflate(R.layout.fragment_premium, container, false)
         val dbhelper= activity?.let { Dbhelper(it) }
         mListPackages=dbhelper!!.getpremiumpackage()
         v.rvPremiumPackage.layoutManager=
             LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
         v.rvPremiumPackage.adapter= activity?.let {
             RecyclerAdapterBasicPackages(
                 it,
                 mListPackages,
                 object :
                     RecyclerAdapterBasicPackages.CellClickListener {
                     override fun onCellClickistener(myobject: Packages, position: Int) {
                         val intent = Intent(activity, NutritionistCounsellorsActivity::class.java)
                         intent.putExtra("packages", myobject)
                         intent.putExtra("position", position)
                         startActivity(intent)
                     }
                 })
         }

        v.ivvideo.setOnClickListener {
            v.ivplaystop.visibility=View.GONE
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
                    val videoId = "RarcD0Q50nU"
                    youTubePlayer.loadVideo(videoId, 0f)
                }
            })

            dialog.ivCancel.setOnClickListener {
                v.ivplaystop.visibility=View.VISIBLE
                dialog.cancel()
            }
            dialog.show()
        }
        return v
    }
}
