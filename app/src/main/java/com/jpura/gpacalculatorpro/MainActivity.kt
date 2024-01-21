package com.jpura.gpacalculatorpro

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.jpura.gpacalculatorpro.adapter.StudentAdapter
import com.jpura.gpacalculatorpro.databinding.ActivityMainBinding
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Student
import com.jpura.gpacalculatorpro.utils.Utils.Companion.setUpBannerAd
import com.jpura.gpacalculatorpro.utils.Utils.Companion.showRewardAd


// key store pass: gpacalculatorpro

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    val dbHelper = StudentDatabaseHelper(this)

     var rewardedAd: RewardedAd ?= null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        MobileAds.initialize(this) {}
        setUpBannerAd(binding.homeAdView)

//        rewardAd(this,"ca-app-pub-5059073603666860/6466009454", "MainActivityRAd")

        val students = dbHelper.getAllStudents()

        val studentAdapter = StudentAdapter(students, this)

        binding.studentRv.layoutManager = LinearLayoutManager(this)
        binding.studentRv.adapter = studentAdapter

        binding.addStudntIv.setOnClickListener {
            showDialog()
        }

        binding.supportIv.setOnClickListener {
            startActivity(Intent(this, SupportActivity::class.java))
        }

        checkEmpty()

        binding.studentRv.setOnClickListener {
            Toast.makeText(this, "da", Toast.LENGTH_SHORT).show()
        }
    }


    fun rewardAd(context: Context, adId: String, TAG: String) {
        var adRequest = AdRequest.Builder().build()
        RewardedAd.load(context, adId, adRequest, object : RewardedAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                adError?.toString()?.let { Log.d(TAG, it) }
                rewardedAd = null
            }

            override fun onAdLoaded(ad: RewardedAd) {
                Log.d(TAG, "Ad was loaded.")
                rewardedAd = ad
                showRewardAd(TAG, rewardedAd!!, this@MainActivity)
            }
        })
    }



    fun checkEmpty(){
        val stu = dbHelper.getAllStudents()
        if (stu.isEmpty()){
            binding.notFoundTv.visibility = View.VISIBLE
        }else{
            binding.notFoundTv.visibility = View.GONE
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_student_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner)
        val items = listOf("Information Communication Technology", "Engineering Technology", "Bio System Technology") // Your dropdown items
        val adapter = ArrayAdapter<String>(this, R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        var selectedItem: String = ""

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = items[position] // Get the selected item

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val addBtn = dialog.findViewById<Button>(R.id.addStudentBtn)
        addBtn.setOnClickListener {
            val name = dialog.findViewById<EditText>(R.id.studentNameEt)
            if (name.text.isNotEmpty() && selectedItem != ""){
                val newStudent = Student(-1, name.text.toString(), 0.0f, selectedItem, "")
                dbHelper.insertStudent(newStudent)
                Toast.makeText(this, "Student added successfully!", Toast.LENGTH_SHORT).show()

                val students = dbHelper.getAllStudents()
                val studentAdapter = StudentAdapter(students, this)
                binding.studentRv.layoutManager = LinearLayoutManager(this)
                binding.studentRv.adapter = studentAdapter
                dialog.dismiss()
            }
            checkEmpty()

        }

        dialog.show()
    }




}