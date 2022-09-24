package com.example.roomdatabase.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.roomdatabase.entities.DirectorEntity
import com.example.roomdatabase.entities.SchoolEntity

data class SchoolAndDirector(
    @Embedded val school: SchoolEntity,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: DirectorEntity
)