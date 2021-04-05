package com.applocum.fitzoh.ui.mainscreen.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.viewpager.widget.PagerAdapter
import com.applocum.fitzoh.R
import java.util.*

class ViewPagerAdapter(context: Context,images: IntArray) :PagerAdapter(){
    private var mcontext = context
    private var mimages = images

    private var layoutInflater: LayoutInflater =
        mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun getCount(): Int {
        return mimages.size
    }
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val itemView = layoutInflater.inflate(R.layout.raw_image_xml, container, false)
        val imageView: ImageView =
            itemView.findViewById<View>(R.id.imageview) as ImageView
        imageView.setImageResource(mimages[position])
        Objects.requireNonNull(container).addView(itemView)
        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }
}