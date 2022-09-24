package com.example.roomdatabase.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DirectorEntity(
    @PrimaryKey(autoGenerate = false)
    val directorName: String,
    val schoolName: String
)