package com.example.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SchoolEntity(
    @PrimaryKey(autoGenerate = false)
    val schoolName: String
)
