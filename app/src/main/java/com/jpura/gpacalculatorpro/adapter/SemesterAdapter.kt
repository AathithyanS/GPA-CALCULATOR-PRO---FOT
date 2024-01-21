package com.jpura.gpacalculatorpro.adapter

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jpura.gpacalculatorpro.ModuleActivity
import com.jpura.gpacalculatorpro.R
import com.jpura.gpacalculatorpro.SemisterActivity
import com.jpura.gpacalculatorpro.databinding.SemesterItemBinding
import com.jpura.gpacalculatorpro.databinding.SemesterLayoutBinding
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Module
import com.jpura.gpacalculatorpro.model.Semester
import com.jpura.gpacalculatorpro.utils.Utils

class SemesterAdapter(val semesters: ArrayList<Semester>, val context: SemisterActivity, val studentId:Long, val dep: String, val focus:String): RecyclerView.Adapter<SemesterAdapter.ViewHolder>() {

    val dbHelper = StudentDatabaseHelper(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SemesterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val semi =semesters.get(position)
        holder.semesterName.text = "Semester ${semi.name}"
        holder.semesterGpa.text = UpdateGpa(semi.id).toString()

        holder.semesterCl.setOnClickListener {
            val intent = Intent(context, ModuleActivity::class.java)
            intent.putExtra("id", semi.id)
            intent.putExtra("semi", semi.name.toString())
            intent.putExtra("idS", studentId)
            intent.putExtra("department", dep)
            intent.putExtra("focus", focus)
            context.startActivity(intent)
            context.finish()
        }
        holder.removeSemiIv.setOnClickListener {
            dbHelper.deleteSemesterBySemesterId(semi.id)
            removeSemister(position)
            context.checkEmpty()
            context.updateGpa()
        }

    }



    private fun removeSemister(position: Int) {
        if (position >= 0 && position < semesters.size) {
            semesters.removeAt(position)
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int {
        return semesters.size
    }


    inner class ViewHolder(private val binding: SemesterItemBinding): RecyclerView.ViewHolder(binding.root){
        val semesterName = binding.semisterNoTv
        val semesterGpa = binding.semesterGpaTv
        val removeSemiIv = binding.removeSemiIv
        val semesterCl = binding.semesterCl
    }

    fun UpdateGpa(id: Long): Float{
        val moduleResult = dbHelper.getAllModulesBySemesterId(id);
        val gpa = Utils.calculateGPA(moduleResult)
        return gpa
    }



}