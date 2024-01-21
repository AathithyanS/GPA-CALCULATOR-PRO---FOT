package com.jpura.gpacalculatorpro.model

data class Student(
    var id: Long = -1,
    var name: String,
    var gpa:Float,
    var department: String,
    var focus:String
)