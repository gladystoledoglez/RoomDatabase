package com.example.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomdatabase.entities.DirectorEntity
import com.example.roomdatabase.entities.SchoolEntity
import com.example.roomdatabase.entities.StudentEntity
import com.example.roomdatabase.entities.SubjectEntity
import com.example.roomdatabase.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        SchoolEntity::class,
        StudentEntity::class,
        DirectorEntity::class,
        SubjectEntity::class,
        StudentSubjectCrossRef::class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            synchronized(this) {
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}