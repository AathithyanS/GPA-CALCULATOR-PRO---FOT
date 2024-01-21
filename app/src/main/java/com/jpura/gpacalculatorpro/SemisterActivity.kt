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
import android.widget.Spinner
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback
import com.jpura.gpacalculatorpro.adapter.SemesterAdapter
import com.jpura.gpacalculatorpro.databinding.ActivitySemisterBinding
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Module
import com.jpura.gpacalculatorpro.model.Semester
import com.jpura.gpacalculatorpro.model.ict.BstModules.getBstSemesterModules
import com.jpura.gpacalculatorpro.model.ict.EgtModules.getEgtSemesterModules
import com.jpura.gpacalculatorpro.model.ict.IctModules.getICTSemesterModules
import com.jpura.gpacalculatorpro.model.ict.TechModule
import com.jpura.gpacalculatorpro.utils.Utils
import com.jpura.gpacalculatorpro.utils.Utils.Companion.calculateGPA

class SemisterActivity : AppCompatActivity() {

    lateinit var semeAdapter: SemesterAdapter;
    lateinit var binding:ActivitySemisterBinding
    val dbHelper = StudentDatabaseHelper(this)
    var rewardedAd: RewardedAd?= null

    var studentId: Long = -1
    var department: String = ""
    var focus: String =  ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySemisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}
        Utils.setUpBannerAd(binding.semesterAdView)

//        rewardAd(this,"ca-app-pub-5059073603666860/4600046401", "SemesterActivityRAd")

        studentId = intent.getLongExtra("id", -1)
        department = intent.getStringExtra("department")!!
        focus = intent.getStringExtra("focus")!!

        val semesters = dbHelper.getAllSemestersByStudentId(studentId)
        semeAdapter = SemesterAdapter(semesters, this, studentId, department, focus)
        binding.semesterRv.layoutManager = LinearLayoutManager(this)
        binding.semesterRv.adapter = semeAdapter

        binding.addSemisterIv.setOnClickListener {
            showDialog()
        }

        binding.semesterBackIv.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(0, 0)
            finish()
        }

        updateGpa()
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
                Utils.showRewardAd(TAG, rewardedAd!!, this@SemisterActivity)
            }
        })
    }

    private fun addSemester() {
        val semesters = dbHelper.getAllSemestersByStudentId(studentId)
        val updateAdapter = SemesterAdapter(semesters, this, studentId, department, focus)
        binding.semesterRv.adapter = updateAdapter
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_semester_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val spinner = dialog.findViewById<Spinner>(R.id.semesterSpinner)
        val items = listOf("1","2","3","4","5","6","7","8","9","10")
        val adapter = ArrayAdapter<String>(this, R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        var selectedItem:Long = -1

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = items[position].toLong()// Get the selected item

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val addBtn = dialog.findViewById<Button>(R.id.addSemiBtn)
        addBtn.setOnClickListener {

            if (selectedItem != -1L){
                val newSemi = Semester(-1, selectedItem, studentId, 0.0f)
                
                if (department.equals("Information Communication Technology") && selectedItem <= 4) {
                    checkAndAddSemi(newSemi, dialog, selectedItem)
                }else if (department.equals("Engineering Technology") && selectedItem <= 2) {
                    checkAndAddSemi(newSemi, dialog, selectedItem)
                }else if (department.equals("Bio System Technology") && selectedItem <= 2) {
                    checkAndAddSemi(newSemi, dialog, selectedItem)
                }else if (focus == "" && department.equals("Information Communication Technology") && selectedItem > 4){
                    showFocusDialog(department)
                }else if (focus == "" && department.equals("Engineering Technology") && selectedItem > 2){
                    showFocusDialog(department)
                }else if (focus == "" && department.equals("Bio System Technology") && selectedItem > 2){
                    showFocusDialog(department)
                }else if (focus != "" && department.equals("Information Communication Technology") && selectedItem > 4){
                    checkAndAddSemi(newSemi, dialog, selectedItem, focus)
                }else if (focus != "" && department.equals("Engineering Technology") && selectedItem > 2){
                    checkAndAddSemi(newSemi, dialog, selectedItem, focus)
                }else if (focus != "" && department.equals("Bio System Technology") && selectedItem > 2){
                    checkAndAddSemi(newSemi, dialog, selectedItem, focus)
                }
                updateGpa()
            }

        }
        checkEmpty()
        dialog.show()
    }

    fun checkEmpty(){
        val stu = dbHelper.getAllModulesByStudentId(studentId)
        if (stu.isEmpty()){
            binding.notFoundTv.visibility = View.VISIBLE
        }else{
            binding.notFoundTv.visibility = View.GONE
        }
    }

    private fun checkAndAddSemi(newSemi: Semester, dialog:Dialog, selectedItem: Long, focus:String = "") {
        val id = dbHelper.insertSemester(newSemi)
        Toast.makeText(this, "Semester added success fully!", Toast.LENGTH_SHORT).show()
        if (id != -1L) {
            addSemester()
            if (department.equals("Information Communication Technology")){
                val modules = getICTSemesterModules(department, selectedItem.toInt(), focus)
                Log.d("ICTGET", "checkAndAddSemi: $department, ${selectedItem}, $focus")
                for (module: TechModule in modules){
                    val mod = Module(-1, module.name, module.credit, 4.0f , id)
                    dbHelper.insertModule(mod)
                }
            }else if(department.equals("Bio System Technology")){
                val modules = getBstSemesterModules(department, selectedItem.toInt(), focus)
                Log.d("ICTGET", "checkAndAddSemi: $department, ${selectedItem}, $focus")
                for (module: TechModule in modules){
                    val mod = Module(-1, module.name, module.credit, 4.0f , id)
                    dbHelper.insertModule(mod)
                }
            }else if(department.equals("Engineering Technology")){
                val modules = getEgtSemesterModules(department, selectedItem.toInt(), focus)
                Log.d("ICTGET", "checkAndAddSemi: $department, ${selectedItem}, $focus")
                for (module: TechModule in modules){
                    val mod = Module(-1, module.name, module.credit, 4.0f , id)
                    dbHelper.insertModule(mod)
                }
            }

            dialog.dismiss()
        }else{ Toast.makeText(this, "Semester$selectedItem is already exist!", Toast.LENGTH_SHORT).show()
        }
        checkEmpty()
    }

    private fun showFocusDialog(department: String) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_focus_dialog)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val spinner = dialog.findViewById<Spinner>(R.id.focusSpinner)
        val selectBtn = dialog.findViewById<Button>(R.id.addFocus)

        var items = listOf("")
        if (department.equals("Information Communication Technology")){
            items = listOf("Multimedia Technology", "Network Technology", "Software Technology")
        }else if (department.equals("Engineering Technology")){
            items = listOf("Construction and Building Services Technology", "Energy and Environmental Technology", "Geotechnology","Automobile Technology", "Mechatronics Technology", "Polymer Processing Technology")
        }else if (department.equals("Bio System Technology")){
            items = listOf("Agriculture and Environmental Technology", "Food Processing Technology", "Industrial Biosystems Technology")
        }

        val adapter = ArrayAdapter<String>(this, R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
        var selectedItem:String = ""

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedItem = items[position]
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        selectBtn.setOnClickListener {
            val check = dbHelper.updateStudentFocus(studentId, selectedItem)
            if (check){
                focus = selectedItem
            }
            addSemester()
            dialog.dismiss()
        }

        dialog.show()
    }

    fun updateGpa(){
        val stuModule = dbHelper.getAllModulesByStudentId(studentId)
        val gpa = calculateGPA(stuModule)
        binding.semesterOverallGpaTv.text = gpa.toString()

    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        overridePendingTransition(0, 0)
        finish()
    }

}