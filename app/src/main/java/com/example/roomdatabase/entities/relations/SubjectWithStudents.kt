package com.example.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomdatabase.entities.StudentEntity
import com.example.roomdatabase.entities.SubjectEntity

data class SubjectWithStudents(
    @Embedded val subject: SubjectEntity,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<StudentEntity>
)
