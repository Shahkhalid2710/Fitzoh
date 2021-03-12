package com.applocum.fitzoh.ui.home.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerFragmentAdapter(context: Context,fm:FragmentManager):FragmentPagerAdapter(fm) {
    var list:ArrayList<Fragment> = ArrayList()
    var titlelist:ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return list.get(position)
    }

    override fun getCount(): Int {
        return list.size
    }

    fun addfragment(fragment: Fragment,title:String)
    {
        list.add(fragment)
        titlelist.add(title)

    }
    override fun getPageTitle(position: Int): CharSequence? {
        return titlelist.get(position)
    }
}