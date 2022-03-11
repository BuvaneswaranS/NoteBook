package com.example.task_2_notes.notesdatabase

//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update

//@Dao
//interface NotesDao {
//
////  Inserting a New Note into the Database
//    @Insert
//    fun insertNotesData(data: NotesData)
//
////  Updating the Existing Note
//    @Update
//    fun updateNotesData(data: NotesData)
//
////   Getting the Notes Data for a separate folder
//    @Query("SELECT * from notes_table WHERE Folder_Name = :tableName")
//    fun getNotesForSeparateTable(tableName: String)
//
////  Deleting a single Note from the Table
//    @Query("DELETE FROM  notes_table WHERE uniqueKey = :key")
//    fun deleteNote(key: Long)
//
////  Deleting all the Notes in the Folder
//    @Query("DELETE  FROM  notes_table WHERE Folder_Name = :tableName")
//    fun deleteNotesOfFolder(tableName: String)
//
////   Delete all the notes
//    @Query("DELETE  FROM  notes_table")
//    fun deleteAll()
//
//
//}