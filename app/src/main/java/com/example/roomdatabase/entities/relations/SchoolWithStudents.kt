package com.example.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabase.entities.SchoolEntity
import com.example.roomdatabase.entities.StudentEntity

data class SchoolWithStudents(
    @Embedded val school: SchoolEntity,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students: List<StudentEntity>
)