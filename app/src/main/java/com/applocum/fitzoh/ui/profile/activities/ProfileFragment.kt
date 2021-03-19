package com.applocum.fitzoh.ui.profile.activities

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.mainscreen.activities.MainActivity
import kotlinx.android.synthetic.main.activity_edit_profile.*
import kotlinx.android.synthetic.main.fragment_profile.*
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

        v.tvEditProfile.setOnClickListener {
            val intent=Intent(activity,EditProfileActivity::class.java)
            startActivity(intent)
        }


        val dbhelper= activity?.let { Dbhelper(it) }

        sharedPreferences=activity!!.getSharedPreferences("mypref", AppCompatActivity.MODE_PRIVATE)
        val email=sharedPreferences.getString("email","")

       val user= email?.let { dbhelper?.signin(it) }

        v.tvKg.setText(user?.userWeight)
        v.tvName.setText(user?.userName)
        return v

    }
}