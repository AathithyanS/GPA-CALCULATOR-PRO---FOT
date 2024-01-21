package com.jpura.gpacalculatorpro.db

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jpura.gpacalculatorpro.model.Module
import com.jpura.gpacalculatorpro.model.Semester
import com.jpura.gpacalculatorpro.model.Student

class StudentDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "StudentDatabase.db"
        private const val TABLE_NAME = "Student"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_GPA = "gpa"
        private const val COLUMN_DEPARTMENT = "department"
        private const val COLUMN_FOCUS = "focus"

        // New table for semesters
        private const val TABLE_NAME_SEMESTER = "Semester"
        private const val COLUMN_SEMESTER_ID = "semester_id"
        private const val COLUMN_SEMESTER_NAME = "semester_name"
        private const val COLUMN_STUDENT_ID = "student_id" // Foreign key
        private const val COLUMN_SEME_GPA = "gpa" // Foreign key

        private const val TABLE_NAME_MODULE = "Module"
        private const val COLUMN_MODULE_ID = "id"
        private const val COLUMN_MODULE_NAME = "name"
        private const val COLUMN_MODULE_CREDIT = "credit"
        private const val COLUMN_MODULE_MY_CREDIT = "myCredit"
        private const val COLUMN_MODULE_SEMESTER_ID = "semesterId"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = "CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_NAME TEXT NOT NULL," +
                "$COLUMN_GPA REAL DEFAULT 0.00," +
                "$COLUMN_DEPARTMENT TEXT NOT NULL," +
                "$COLUMN_FOCUS TEXT DEFAULT ''" +
                ");"
        db.execSQL(createTableQuery)

        val createSemesterTableQuery = "CREATE TABLE $TABLE_NAME_SEMESTER (" +
                "$COLUMN_SEMESTER_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_SEMESTER_NAME INTEGER NOT NULL," +
                "$COLUMN_STUDENT_ID INTEGER NOT NULL," +
                "$COLUMN_SEME_GPA REAL DEFAULT 0.00," +
                "UNIQUE ($COLUMN_SEMESTER_NAME, $COLUMN_STUDENT_ID)," +
                "FOREIGN KEY ($COLUMN_STUDENT_ID) REFERENCES $TABLE_NAME ($COLUMN_ID)" +
                ");"
        db.execSQL(createSemesterTableQuery)

        val createModuleTableQuery = "CREATE TABLE $TABLE_NAME_MODULE (" +
                "$COLUMN_MODULE_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_MODULE_NAME TEXT NOT NULL," +
                "$COLUMN_MODULE_CREDIT REAL NOT NULL," +
                "$COLUMN_MODULE_MY_CREDIT REAL NOT NULL," +
                "$COLUMN_MODULE_SEMESTER_ID INTEGER NOT NULL," +
                "FOREIGN KEY ($COLUMN_MODULE_SEMESTER_ID) REFERENCES $TABLE_NAME_SEMESTER ($COLUMN_SEMESTER_ID)" +
                ");"
        db.execSQL(createModuleTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertStudent(student: Student) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_NAME, student.name)
        values.put(COLUMN_GPA, student.gpa)
        values.put(COLUMN_DEPARTMENT, student.department)
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllStudents(): ArrayList<Student> {
        val studentList = ArrayList<Student>()
        val db = this.readableDatabase
        val selectQuery = "SELECT * FROM $TABLE_NAME ORDER BY $COLUMN_ID DESC"

        val cursor = db.rawQuery(selectQuery, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
                val gpa = cursor.getFloat(cursor.getColumnIndex(COLUMN_GPA))
                val department = cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT))
                val focus = cursor.getString(cursor.getColumnIndex(COLUMN_FOCUS))

                val student = Student(id, name, gpa, department, focus)
                studentList.add(student)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return studentList
    }

    fun removeStudentById(studentId: Long) {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(studentId.toString())

        // Delete the student record with the specified id
        db.delete(TABLE_NAME, whereClause, whereArgs)

        db.close()
    }

    @SuppressLint("Range")
    fun getStudentById(studentId: Long): Student? {
        val db = this.readableDatabase
        val selection = "$COLUMN_ID = ?"
        val selectionArgs = arrayOf(studentId.toString())
        val cursor = db.query(TABLE_NAME, null, selection, selectionArgs, null, null, null)

        var student: Student? = null

        if (cursor.moveToFirst()) {
            val id = cursor.getLong(cursor.getColumnIndex(COLUMN_ID))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME))
            val gpa = cursor.getFloat(cursor.getColumnIndex(COLUMN_GPA))
            val department = cursor.getString(cursor.getColumnIndex(COLUMN_DEPARTMENT))
            val focus = cursor.getString(cursor.getColumnIndex(COLUMN_FOCUS))

            student = Student(id, name, gpa, department, focus)
        }

        cursor.close()
        db.close()

        return student
    }



    fun updateStudentFocus(studentId: Long, newFocus: String): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_FOCUS, newFocus)

        val whereClause = "$COLUMN_ID = ?"
        val whereArgs = arrayOf(studentId.toString())

        val rowsAffected = db.update(TABLE_NAME, values, whereClause, whereArgs)
        db.close()

        // Check if any rows were affected (updated)
        return rowsAffected > 0
    }

    @SuppressLint("Range")
    fun getAllSemestersByStudentId(studentId: Long): ArrayList<Semester> {
        val semesterList = ArrayList<Semester>()
        val db = this.readableDatabase
        val selection = "$COLUMN_STUDENT_ID = ?"
        val selectionArgs = arrayOf(studentId.toString())
        val orderBy = "$COLUMN_SEMESTER_NAME ASC"
        val cursor = db.query(TABLE_NAME_SEMESTER, null, selection, selectionArgs, null, null, orderBy)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_SEMESTER_ID))
                val name = cursor.getLong(cursor.getColumnIndex(COLUMN_SEMESTER_NAME))
                val studentId = cursor.getLong(cursor.getColumnIndex(COLUMN_STUDENT_ID))
                val gpa = cursor.getFloat(cursor.getColumnIndex(COLUMN_SEME_GPA))
                val semester = Semester(id, name, studentId, gpa)
                semesterList.add(semester)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return semesterList
    }

    fun insertSemester(semester: Semester): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_SEMESTER_NAME, semester.name)
        values.put(COLUMN_STUDENT_ID, semester.studentId)
        values.put(COLUMN_SEME_GPA, semester.gpa)
        val insertedId = db.insert(TABLE_NAME_SEMESTER, null, values)
        db.close()
        return insertedId
    }

    fun deleteSemesterBySemesterId(semesterId: Long) {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_SEMESTER_ID = ?"
        val whereArgs = arrayOf(semesterId.toString())
        db.delete(TABLE_NAME_SEMESTER, whereClause, whereArgs)
        db.close()
    }

    fun insertModule(module: Module): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_MODULE_NAME, module.name)
        values.put(COLUMN_MODULE_CREDIT, module.credit)
        values.put(COLUMN_MODULE_MY_CREDIT, module.myCredit)
        values.put(COLUMN_MODULE_SEMESTER_ID, module.semesterId)
        val insertedId = db.insert(TABLE_NAME_MODULE, null, values)
        db.close()
        return insertedId
    }


    fun deleteModulesBySemesterId(semesterId: Long) {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_MODULE_SEMESTER_ID = ?"
        val whereArgs = arrayOf(semesterId.toString())
        db.delete(TABLE_NAME_MODULE, whereClause, whereArgs)
        db.close()
    }

    @SuppressLint("Range")
    fun getAllModulesBySemesterId(semesterId: Long): ArrayList<Module> {
        val moduleList = ArrayList<Module>()
        val db = this.readableDatabase
        val selection = "$COLUMN_MODULE_SEMESTER_ID = ?"
        val selectionArgs = arrayOf(semesterId.toString())
        val cursor = db.query(TABLE_NAME_MODULE, null, selection, selectionArgs, null, null, null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_MODULE_NAME))
                val credit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_CREDIT))
                val myCredit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_MY_CREDIT))
                val semesterId = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_SEMESTER_ID))
                val module = Module(id, name, credit, myCredit, semesterId)
                moduleList.add(module)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return moduleList
    }

    fun deleteModuleByModuleId(moduleId: Long) {
        val db = this.writableDatabase
        val whereClause = "$COLUMN_MODULE_ID = ?"
        val whereArgs = arrayOf(moduleId.toString())
        db.delete(TABLE_NAME_MODULE, whereClause, whereArgs)
        db.close()
    }


    fun updateModuleMyCreditByModuleId(moduleId: Long, newMyCredit: Float) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_MODULE_MY_CREDIT, newMyCredit)

        val whereClause = "$COLUMN_MODULE_ID = ?"
        val whereArgs = arrayOf(moduleId.toString())

        db.update(TABLE_NAME_MODULE, values, whereClause, whereArgs)
        db.close()
    }



    @SuppressLint("Range")
    fun getAllModulesByStudentId(studentId: Long): ArrayList<Module> {
        val moduleList = ArrayList<Module>()
        val db = this.readableDatabase

        // Define the query to retrieve modules by student ID
        val query = "SELECT * FROM $TABLE_NAME_MODULE WHERE $COLUMN_MODULE_SEMESTER_ID IN " +
                "(SELECT $COLUMN_SEMESTER_ID FROM $TABLE_NAME_SEMESTER WHERE $COLUMN_STUDENT_ID = ?)"

        val selectionArgs = arrayOf(studentId.toString())
        val cursor = db.rawQuery(query, selectionArgs)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_ID))
                val name = cursor.getString(cursor.getColumnIndex(COLUMN_MODULE_NAME))
                val credit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_CREDIT))
                val myCredit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_MY_CREDIT))
                val semesterId = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_SEMESTER_ID))
                val module = Module(id, name, credit, myCredit, semesterId)
                moduleList.add(module)
            } while (cursor.moveToNext())
        }

        cursor.close()
        db.close()

        return moduleList
    }

    @SuppressLint("Range")
    fun getModuleById(moduleId: Long): Module? {
        val db = this.readableDatabase
        val selection = "$COLUMN_MODULE_ID = ?"
        val selectionArgs = arrayOf(moduleId.toString())
        val cursor = db.query(TABLE_NAME_MODULE, null, selection, selectionArgs, null, null, null)

        var module: Module? = null

        if (cursor.moveToFirst()) {
            val id = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_ID))
            val name = cursor.getString(cursor.getColumnIndex(COLUMN_MODULE_NAME))
            val credit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_CREDIT))
            val myCredit = cursor.getFloat(cursor.getColumnIndex(COLUMN_MODULE_MY_CREDIT))
            val semesterId = cursor.getLong(cursor.getColumnIndex(COLUMN_MODULE_SEMESTER_ID))
            module = Module(id, name, credit, myCredit, semesterId)
        }

        cursor.close()
        db.close()

        return module
    }



}
