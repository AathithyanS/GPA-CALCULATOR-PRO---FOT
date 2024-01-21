package com.jpura.gpacalculatorpro.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.jpura.gpacalculatorpro.MainActivity
import com.jpura.gpacalculatorpro.R
import com.jpura.gpacalculatorpro.SemisterActivity
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Student
import com.jpura.gpacalculatorpro.utils.Utils

class StudentAdapter(var students: ArrayList<Student>, val context: MainActivity): RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    val db = StudentDatabaseHelper(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        val oldStudent = students.get(position)
        var student = db.getStudentById(oldStudent.id)
        holder.name.text = student!!.name
        holder.gpa.text = updateGpa(student.id).toString()
        holder.department.text = student!!.department
        holder.card.setOnClickListener {
            var student = db.getStudentById(oldStudent.id)!!
            val intent = Intent(context, SemisterActivity::class.java)
            intent.putExtra("id", student.id)
            intent.putExtra("department", student.department)
            intent.putExtra("focus", student.focus)
            context.startActivity(intent)
            context.finish()
        }
        holder.remove.setOnClickListener {
            db.removeStudentById(student.id)
            context.checkEmpty()
            updateChange()
        }

    }

    private fun updateChange() {
        students = db.getAllStudents()
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return students.size;
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.nameTv)
        val gpa: TextView = itemView.findViewById(R.id.gpaTv)
        val department: TextView = itemView.findViewById(R.id.departmentTv)
        val card: ConstraintLayout = itemView.findViewById(R.id.studentCl)
        val remove: ImageView = itemView.findViewById(R.id.userRemoveIv)
    }

    fun updateGpa(studentId: Long): Float {
        val stuModule = db.getAllModulesByStudentId(studentId)
        return Utils.calculateGPA(stuModule)

    }



}