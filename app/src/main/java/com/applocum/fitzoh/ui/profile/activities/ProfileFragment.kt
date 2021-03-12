package com.applocum.fitzoh.ui.profile.activities

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.mainscreen.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    lateinit var sharedPreferences : SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(R.layout.fragment_profile, container, false)
        v.tvLogout.setOnClickListener {
            sharedPreferences=activity!!.getSharedPreferences("mypref",MODE_PRIVATE)
            editor=sharedPreferences.edit()
            editor.clear()
            editor.commit()

            val intent= Intent(activity,
                MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        return v

    }
}