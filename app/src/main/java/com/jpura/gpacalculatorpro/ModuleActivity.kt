package com.jpura.gpacalculatorpro

import android.app.Dialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.jpura.gpacalculatorpro.adapter.ModulesAdapter
import com.jpura.gpacalculatorpro.adapter.SemesterAdapter
import com.jpura.gpacalculatorpro.databinding.ActivityModuleBinding
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Module
import com.jpura.gpacalculatorpro.model.Semester
import com.jpura.gpacalculatorpro.model.ict.TechModule
import com.jpura.gpacalculatorpro.utils.Utils

class ModuleActivity : AppCompatActivity() {

    lateinit var binding: ActivityModuleBinding
    val dbHelper = StudentDatabaseHelper(this)
    var id:Long = -1L
    var sId:Long = -1L
    var department = ""
    var semi = ""
    var focus = ""
    lateinit var modules: ArrayList<Module>


    var rewardedAd: RewardedAd?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        Utils.setUpBannerAd(binding.moduleAdView)

        rewardAd(this,"ca-app-pub-5059073603666860/3286964732", "ModuleActivityRAd")

        sId = intent.getLongExtra("idS", -1L)
        department = intent.getStringExtra("department")!!
        semi = intent.getStringExtra("semi")!!
        focus = intent.getStringExtra("focus")!!

        id = intent.getLongExtra("id", -1)

        binding.semisterModNoTv.setText("Semester $semi")

        modules = dbHelper.getAllModulesBySemesterId(id)
        val adapter = ModulesAdapter(modules, this, id)
        binding.moduleRv.layoutManager = LinearLayoutManager(this)
        binding.moduleRv.adapter = adapter
        binding.addModuleIv.setOnClickListener {
            showDialog(this, adapter)
        }

        binding.moduleBackIv.setOnClickListener {
            val intent  = Intent(this, SemisterActivity::class.java)
            intent.putExtra("id", sId)
            intent.putExtra("department", department)
            intent.putExtra("focus", focus)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        UpdateGpa()
        checkEmpty()



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
                Utils.showRewardAd(TAG, rewardedAd!!, this@ModuleActivity)
            }
        })
    }


    private fun showDialog(
        context: Context,
        adapter: ModulesAdapter,

    ) {
        var dialog:Dialog;
        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.add_module_dialog, null, false)
        dialog = Dialog(context)
        dialog.setContentView(dialogView)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        val addBtn = dialogView.findViewById<Button>(R.id.addModuleBtn)
        val moduleName = dialogView.findViewById<EditText>(R.id.moduleNameEt)
        val moduleCredit = dialogView.findViewById<EditText>(R.id.moduleCreditEt)
        addBtn.setOnClickListener {
            if(moduleName.text.isNotEmpty() && moduleName.text != null && moduleCredit.text.isNotEmpty() && moduleCredit.text != null){
                if(moduleCredit.text.toString().toFloat() <= 4) {
                    addModule(adapter, moduleName.text.toString(), moduleCredit.text.toString())
                    dialog.dismiss()
                }else{
                    Toast.makeText(this, "Credit can't enter grater than 4!", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(context, "Fields can't be empty!", Toast.LENGTH_SHORT).show()
            }
            checkEmpty()
        }

        dialog.show()
    }

    fun checkEmpty(){
        val stu = dbHelper.getAllModulesBySemesterId(id)
        if (stu.isEmpty()){
            binding.notFoundTv.visibility = View.VISIBLE
        }else{
            binding.notFoundTv.visibility = View.GONE
        }
    }

    private fun addModule(adapter: ModulesAdapter, name: String, credit: String) {
        val m = Module(-1, name, credit.toFloat(), 4.0f, id)
        val id = dbHelper.insertModule(m)
        adapter.addModule(m, id)
    }

     fun UpdateGpa(){
        val moduleResult = dbHelper.getAllModulesBySemesterId(id);
        val gpa = Utils.calculateGPA(moduleResult)
        binding.semesterGpaTv.text = gpa.toString()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent  = Intent(this, SemisterActivity::class.java)
        intent.putExtra("id", sId)
        intent.putExtra("department", department)
        intent.putExtra("focus", focus)
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
    }
}