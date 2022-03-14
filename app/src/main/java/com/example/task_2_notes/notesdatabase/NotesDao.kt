package com.example.task_2_notes.notesdatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {

//  Inserting a New Note into the Database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotesData(data: NotesData)

//  Updating the Existing Note
    @Update
    fun updateNotesData(data: NotesData)

//    Get all the notes
    @Query("SELECT * from notes_table ORDER BY uniqueKey ASC")
    fun getAllNotes(): LiveData<List<NotesData>>

//    Get a single Note
    @Query("SELECT * from notes_table")
    fun getNote(): NotesData

    //   Getting the Notes Data for a separate folder
    @Query("SELECT * from notes_table WHERE Folder_Name = :tableName")
    fun getNotesForSeparateTable(tableName: String): LiveData<List<NotesData>>

//  Deleting a single Note from the Table
    @Delete()
    fun deleteNote(note: NotesData)

//  Deleting all the Notes in the Folder
    @Query("DELETE  FROM  notes_table WHERE Folder_Name = :tableName")
    fun deleteNotesOfFolder(tableName: String)

//   Delete all the notes
    @Query("DELETE  FROM  notes_table")
    fun deleteAll()



}