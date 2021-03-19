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
import com.applocum.fitzoh.R
import com.applocum.fitzoh.RecyclerAdapterSessionRequest
import com.applocum.fitzoh.ui.home.models.SessionRequest
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterSessionNumber
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTrainerListing
import com.applocum.fitzoh.ui.home.models.Blog
import com.applocum.fitzoh.ui.home.models.Sessionnumber
import kotlinx.android.synthetic.main.activity_live_session.*
import kotlinx.android.synthetic.main.activity_live_session.ivBack
import kotlinx.android.synthetic.main.custom_filter_layout_xml.view.*

class LiveSessionActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var mListTrainer: ArrayList<SessionRequest> = ArrayList()
    var mListTrainerList: ArrayList<Blog> = ArrayList()
    var mListSessionNumbber: ArrayList<Sessionnumber> = ArrayList()
    @SuppressLint("InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_session)
        ivBack.setOnClickListener {
            finish()
        }

        val sessionRequest1 = SessionRequest(
            R.drawable.jhonmartin,
            "Jhon Martin"
        )
        val sessionRequest2 = SessionRequest(
            R.drawable.robertroy,
            "Robert Ray"
        )
        val sessionRequest3 = SessionRequest(
            R.drawable.jhondoi,
            "Jhon Doi"
        )
        val sessionRequest4 = SessionRequest(
            R.drawable.annyroy,
            "Anny Roy"
        )
        val sessionRequest5 = SessionRequest(
            R.drawable.elaloppes,
            "Eia Loppes"
        )

        mListTrainer.add(sessionRequest1)
        mListTrainer.add(sessionRequest2)
        mListTrainer.add(sessionRequest3)
        mListTrainer.add(sessionRequest4)
        mListTrainer.add(sessionRequest5)


        rvExistingPreviousTrainer.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvExistingPreviousTrainer.adapter = RecyclerAdapterSessionRequest(this, mListTrainer)

        val blog1 = Blog(R.drawable.ena.toString(), "Jenna Hopper", "Experience: 05 years")
        val blog2 = Blog(R.drawable.amelia.toString(), "Amelia Freer", "Experience: 03 years")
        val blog3 = Blog(R.drawable.enablatner.toString(), "Enaa blatner", "Experience: 02 years")
        val blog4 = Blog(R.drawable.bewell.toString(), "Bewell Bykelly", "Experience: 02 years")

        mListTrainerList.add(blog1)
        mListTrainerList.add(blog2)
        mListTrainerList.add(blog3)
        mListTrainerList.add(blog4)

        rvTrainerList.layoutManager = LinearLayoutManager(this)
        rvTrainerList.adapter = RecyclerAdapterTrainerListing(this, mListTrainerList)

        val sessionnumber1 = Sessionnumber("Session -01")
        val sessionnumber2 = Sessionnumber("Session -02")
        val sessionnumber3 = Sessionnumber("Session -03")
        val sessionnumber4 = Sessionnumber("Session -04")
        val sessionnumber5 = Sessionnumber("Session -05")
        val sessionnumber6 = Sessionnumber("Session -06")
        val sessionnumber7 = Sessionnumber("Session -07")

        mListSessionNumbber.add(sessionnumber1)
        mListSessionNumbber.add(sessionnumber2)
        mListSessionNumbber.add(sessionnumber3)
        mListSessionNumbber.add(sessionnumber4)
        mListSessionNumbber.add(sessionnumber5)
        mListSessionNumbber.add(sessionnumber6)
        mListSessionNumbber.add(sessionnumber7)

        rvSession.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvSession.adapter = RecyclerAdapterSessionNumber(this, mListSessionNumbber)


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


          //  showDialogView.spinnerCategory.onItemSelectedListener = this

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
        //val show: String = parent?.getItemAtPosition(position).toString()

      //  spinnerCategory.setText(show)
    }
}