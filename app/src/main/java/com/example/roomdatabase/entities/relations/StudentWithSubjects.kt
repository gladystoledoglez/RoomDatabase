package com.example.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomdatabase.entities.StudentEntity
import com.example.roomdatabase.entities.SubjectEntity

data class StudentWithSubjects(
    @Embedded val student: StudentEntity,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<SubjectEntity>
)
