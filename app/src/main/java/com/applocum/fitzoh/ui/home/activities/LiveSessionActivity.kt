package com.applocum.fitzoh.ui.home.activities

import android.annotation.SuppressLint
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.applocum.fitzoh.Dbhelper
import com.applocum.fitzoh.R
import com.applocum.fitzoh.RecyclerAdapterSessionRequest
import com.applocum.fitzoh.ui.home.adapters.RecyclerAdapterTrainerListing
import com.applocum.fitzoh.ui.home.models.Trainer
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_live_session.*
import kotlinx.android.synthetic.main.activity_live_session.ivBack
import kotlinx.android.synthetic.main.custom_filter_layout_xml.view.*

@Suppress("NAME_SHADOWING")
class LiveSessionActivity : AppCompatActivity() {
    private var mListExistingPreviousTrainer: ArrayList<Trainer> = ArrayList()
    private var mListTrainerList: ArrayList<Trainer> = ArrayList()
    private var mListCategory: ArrayList<String> = ArrayList()
    private var listTrainers:ArrayList<Trainer> = ArrayList()

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
        rvTrainerList.adapter = RecyclerAdapterTrainerListing(this,mListTrainerList)



        tvFilter.setOnClickListener {
            val showDialogView=LayoutInflater.from(this).inflate(R.layout.custom_filter_layout_xml,null,false)
            val dialog = AlertDialog.Builder(this).create()
            dialog.setView(showDialogView)

            showDialogView.etSelectcategory.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Choose Category")

                val lables: MutableList<String> = java.util.ArrayList()
                lables.add("Strength")
                lables.add("Power Yoga")
                lables.add("Mobility & Flexibility")
                lables.add("Yoga-Relaxation")
                lables.add("Meditation")
                lables.add("Powerspeed")

                val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
                builder.setAdapter(dataAdapter) { _, which ->
                    showDialogView.etSelectcategory.setText(lables[which]).toString()
                   mListCategory= dbhelper.getsessionsubcategory((lables[which]))
                }
                val dialog = builder.create()
                dialog.show()
            }
            showDialogView.etSubcategory.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Choose Sub Category")
                Log.d("mylisttttt","-->"+mListCategory)
                val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, mListCategory)
                builder.setAdapter(dataAdapter) { _, which ->
                    showDialogView.etSubcategory.setText(mListCategory[which]).toString()
                }

                val dialog = builder.create()
                dialog.show()
            }
            showDialogView.etlanguage.setOnClickListener {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Choose Language")

                val lables: MutableList<String> = java.util.ArrayList()
                lables.add("English")
                lables.add("Hindi")
                lables.add("Gujarati")
                lables.add("French")
                val dataAdapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lables)
                builder.setAdapter(dataAdapter) { _, which ->
                    showDialogView.etlanguage.setText(lables[which]).toString()
                }

                val dialog = builder.create()
                dialog.show()
            }
            showDialogView.btnCancel.setOnClickListener {
                dialog.dismiss()
            }
            showDialogView.btnSubmit.setOnClickListener {
                val category=showDialogView.etSelectcategory.text.toString()
                val subcategory=showDialogView.etSubcategory.text.toString()
                val language=showDialogView.etlanguage.text.toString()
                if (validatetrainerdata(category,subcategory,language))
                {
                    listTrainers=dbhelper.getTrainerlist(showDialogView.etSelectcategory.text.toString(),showDialogView.etSubcategory.text.toString(),showDialogView.etlanguage.text.toString())

                    if (listTrainers.size > 0)
                    {
                        val recyclerAdapterTrainerListing=RecyclerAdapterTrainerListing(this,listTrainers)
                        rvTrainerList.layoutManager = LinearLayoutManager(this)
                        rvTrainerList.adapter =recyclerAdapterTrainerListing
                        recyclerAdapterTrainerListing.notifyDataSetChanged()
                        tvtrainernotfound.visibility=View.GONE
                    }
                    else
                    {
                        tvtrainernotfound.visibility=View.VISIBLE
                        rvTrainerList.visibility=View.GONE
                    }

                    dialog.dismiss()
                }
            }
            dialog.show()
        }

    }
    private  fun validatetrainerdata(category:String,sabcategory:String,language:String):Boolean
    {
        if (category.isEmpty())
        {
            val snackbar = Snackbar.make(lllivesession, "Please Select Category", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (sabcategory.isEmpty()) {
            val snackbar = Snackbar.make(lllivesession, "Please Select Subcategory", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }
        if (language.isEmpty()) {
            val snackbar = Snackbar.make(lllivesession, "Please Select Language", Snackbar.LENGTH_LONG)
            snackbar.show()
            return false
        }

     return true
    }
}