package com.example.roomdatabase

import androidx.room.*
import com.example.roomdatabase.entities.DirectorEntity
import com.example.roomdatabase.entities.SchoolEntity
import com.example.roomdatabase.entities.StudentEntity
import com.example.roomdatabase.entities.SubjectEntity
import com.example.roomdatabase.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: SchoolEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: DirectorEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: StudentEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: SubjectEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM schoolentity WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirector(schoolName: String): List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM schoolentity WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String): List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subjectentity WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName: String): List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM studententity WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String): List<StudentWithSubjects>
}