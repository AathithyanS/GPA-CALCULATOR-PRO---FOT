package com.jpura.gpacalculatorpro.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jpura.gpacalculatorpro.ModuleActivity
import com.jpura.gpacalculatorpro.R
import com.jpura.gpacalculatorpro.databinding.ModuleItemBinding
import com.jpura.gpacalculatorpro.db.StudentDatabaseHelper
import com.jpura.gpacalculatorpro.model.Module

class ModulesAdapter(val modules: ArrayList<Module>, val context: ModuleActivity, val semiId: Long): RecyclerView.Adapter<ModulesAdapter.ViewHolder>() {

    val dbHelper= StudentDatabaseHelper(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ModuleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val prMod = modules[position]
        val module = dbHelper.getModuleById(prMod.id)!!
        holder.moduleTv.setText(module.name)

        val items = ArrayList<String>() // Your dropdown items
        items.addAll(listOf("A+/A","A-","B+","B","B-","C+","C","C-","D+","D","E"))
        val adapter = ArrayAdapter<String>(context, R.layout.spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        holder.grade.adapter = adapter
        val initialPosition = items.indexOf(getGradeForCredit(module.myCredit))
        if (initialPosition >= 0) {
            holder.grade.setSelection(initialPosition)
        }
        holder.delete.setOnClickListener {
            removeModule(modules,position)
            context.checkEmpty()
        }

        holder.grade.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val grade = getCreditForGrade(items.get(position))
                dbHelper.updateModuleMyCreditByModuleId(module.id, grade)
                context.UpdateGpa()
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }


    }

    private fun removeModule(modules: ArrayList<Module>, position: Int) {
        if (modules.isNotEmpty() && position >= 0 && position < modules.size) {
            dbHelper.deleteModuleByModuleId(modules.get(position).id)
            modules.removeAt(position)
            notifyDataSetChanged()
        }
    }


    override fun getItemCount(): Int {
        return modules.size
    }

    inner class ViewHolder(private val binding: ModuleItemBinding): RecyclerView.ViewHolder(binding.root){
        val moduleTv = binding.modulesEt
        val grade = binding.gradeSpinner
        val delete = binding.moduleDeleteIv
    }

    fun addModule(module: Module, id: Long){
        module.id = id
        modules.add(module)
        notifyDataSetChanged()

    }

    fun saveData() {

    }

    fun getCreditForGrade(grade: String): Float {
        val gradeToCreditMap = mapOf(
            "A+/A" to 4.0f,
            "A-" to 3.7f,
            "B+" to 3.3f,
            "B" to 3.0f,
            "B-" to 2.7f,
            "C+" to 2.3f,
            "C" to 2.0f,
            "C-" to 1.7f,
            "D+" to 1.3f,
            "D" to 1.0f,
            "E" to 0.0f
        )

        return gradeToCreditMap[grade] ?: 0.0f // Return 0.0 if grade is not found in the map
    }

    fun getGradeForCredit(credit: Float): String {
        val creditToGradeMap = mapOf(
            4.0f to "A+",
            4.0f to "A",
            3.7f to "A-",
            3.3f to "B+",
            3.0f to "B",
            2.7f to "B-",
            2.3f to "C+",
            2.0f to "C",
            1.7f to "C-",
            1.3f to "D+",
            1.0f to "D",
            0.0f to "E"
        )

        return creditToGradeMap.entries.find { it.key == credit }?.value ?: "Grade not found"
    }




}