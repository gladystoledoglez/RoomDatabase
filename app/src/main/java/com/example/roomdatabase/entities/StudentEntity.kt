package com.example.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class StudentEntity(
    @PrimaryKey(autoGenerate = false)
    val studentName: String,
    val semester: Int,
    val schoolName: String
)
