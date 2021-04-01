package com.applocum.fitzoh.ui.profile.activities

import android.content.Context.MODE_PRIVATE
import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.ui.home.activities.HolisticHealthTransferActivity
import com.applocum.fitzoh.ui.mainscreen.activities.MainActivity
import kotlinx.android.synthetic.main.fragment_profile.*
import kotlinx.android.synthetic.main.fragment_profile.view.*

class ProfileFragment : Fragment() {

    private lateinit var sharedPreferences : SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v=inflater.inflate(R.layout.fragment_profile, container, false)
        v.rlsignout.setOnClickListener {
            activity?.let { it1 ->
                AlertDialog.Builder(it1)
                    .setTitle("Sign out?")
                    .setMessage("Are you sure you want to Sign Out?")
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("Sign out", DialogInterface.OnClickListener { dialog, which ->
                        sharedPreferences=requireActivity().getSharedPreferences("mypref",MODE_PRIVATE)
                        editor=sharedPreferences.edit()
                        editor.clear()
                        editor.apply()

                        val intent= Intent(activity,
                            MainActivity::class.java)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
                        startActivity(intent)

                    }).create().show()
            }
        }

        v.tvEditProfile.setOnClickListener {
            val intent=Intent(activity,EditProfileActivity::class.java)
            startActivity(intent)
        }

        v.rlPurchase.setOnClickListener {
            val intent=Intent(activity,HolisticHealthTransferActivity::class.java)
            startActivity(intent)
        }

      /*  val dbhelper= activity?.let { Dbhelper(it) }

        sharedPreferences=requireActivity().getSharedPreferences("mypref", AppCompatActivity.MODE_PRIVATE)
        val email=sharedPreferences.getString("email","")

       val user= email?.let { dbhelper?.signin(it) }

        v.tvKg.text = user?.userWeight
        v.tvName.text = user?.userName*/
        return v

    }

    override fun onResume() {
        super.onResume()
        val dbhelper= activity?.let { Dbhelper(it) }

        sharedPreferences=requireActivity().getSharedPreferences("mypref", AppCompatActivity.MODE_PRIVATE)
        val email=sharedPreferences.getString("email","")
        val user= email?.let { dbhelper?.signin(it) }

        tvKg.text = user?.userWeight
        tvName.text = user?.userName

    }
}