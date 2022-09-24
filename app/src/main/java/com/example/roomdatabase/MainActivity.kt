package com.example.roomdatabase

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.roomdatabase.databinding.ActivityMainBinding
import com.example.roomdatabase.entities.DirectorEntity
import com.example.roomdatabase.entities.SchoolEntity
import com.example.roomdatabase.entities.StudentEntity
import com.example.roomdatabase.entities.SubjectEntity
import com.example.roomdatabase.entities.relations.StudentSubjectCrossRef
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
            DirectorEntity("Gavin Belson", "Jake Wharton School"),
            DirectorEntity("Laurie Bream", "Kotlin School"),
            DirectorEntity("Peter Gregory", "JetBrains School")
        )
        val schools = listOf(
            SchoolEntity("Jake Wharton School"),
            SchoolEntity("Kotlin School"),
            SchoolEntity("JetBrains School")
        )
        val subjects = listOf(
            SubjectEntity("Kotlin vs Java"),
            SubjectEntity("Jetpack Compose"),
            SubjectEntity("Kotlin Multi-platform Mobile"),
            SubjectEntity("Android Native vs Flutter"),
            SubjectEntity("How to use AndroidStudio")
        )
        val students = listOf(
            StudentEntity("Richard Hendricks", 2, "Kotlin School"),
            StudentEntity("Nelson Bighetti", 5, "Jake Wharton School"),
            StudentEntity("Bertram Gilfoyle", 8, "Kotlin School"),
            StudentEntity("Dinesh Chugtai", 1, "Kotlin School"),
            StudentEntity("Erlich Bachman", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
            StudentSubjectCrossRef("Richard Hendricks", "Kotlin vs Java"),
            StudentSubjectCrossRef("Richard Hendricks", "How to use AndroidStudio"),
            StudentSubjectCrossRef("Richard Hendricks", "Kotlin Multi-platform Mobile"),
            StudentSubjectCrossRef("Richard Hendricks", "Android Native vs Flutter"),
            StudentSubjectCrossRef("Nelson Bighetti", "Kotlin vs Java"),
            StudentSubjectCrossRef("Bertram Gilfoyle", "Kotlin Multi-platform Mobile"),
            StudentSubjectCrossRef("Dinesh Chugtai", "Kotlin vs Java"),
            StudentSubjectCrossRef("Erlich Bachman", "Jetpack Compose"),
            StudentSubjectCrossRef("Erlich Bachman", "How to use AndroidStudio")
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudent(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }
        }
    }
}