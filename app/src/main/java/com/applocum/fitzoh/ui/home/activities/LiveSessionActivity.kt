package com.applocum.fitzoh.ui.home.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.RecyclerAdapterSessionRequest
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTrainerListing
import com.applocum.fitzoh.ui.home.models.Trainer
import kotlinx.android.synthetic.main.activity_live_session.*
import kotlinx.android.synthetic.main.activity_live_session.ivBack
import kotlinx.android.synthetic.main.custom_filter_layout_xml.view.*

class LiveSessionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var mListExistingPreviousTrainer: ArrayList<Trainer> = ArrayList()
    var mListTrainerList: ArrayList<Trainer> = ArrayList()

    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_session)
        ivBack.setOnClickListener {
            finish()
        }
        val dbhelper=Dbhelper(this)

        mListExistingPreviousTrainer=dbhelper.getallTrainer()
        rvExistingPreviousTrainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExistingPreviousTrainer.adapter = RecyclerAdapterSessionRequest(this, mListExistingPreviousTrainer)


        mListTrainerList=dbhelper.getallTrainer()
        rvTrainerList.layoutManager = LinearLayoutManager(this)
        rvTrainerList.adapter = RecyclerAdapterTrainerListing(this, mListTrainerList)



        tvFilter.setOnClickListener {

            val showDialogView=LayoutInflater.from(this).inflate(R.layout.custom_filter_layout_xml,null,false)
            val dialog = AlertDialog.Builder(this).create()
            dialog.setView(showDialogView)
            val adapter = ArrayAdapter.createFromResource(
                this,R.array.categorylist,R.layout.custom_spinner_xml
            )
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            showDialogView.spinnerCategory.adapter = adapter

            val adapter2 = ArrayAdapter.createFromResource(
                this,R.array.subcategorylist,R.layout.custom_spinner_xml)
            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)


            showDialogView.spinnerSubCategory.adapter = adapter2

            val adapter3 = ArrayAdapter.createFromResource(
                this,R.array.languagelist,R.layout.custom_spinner_xml)
            adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            showDialogView.spinnerLanguage.adapter = adapter3
            showDialogView.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            showDialogView.btnSubmit.setOnClickListener {
                dialog.dismiss()
            }
            dialog.show()
        }

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
    }
}