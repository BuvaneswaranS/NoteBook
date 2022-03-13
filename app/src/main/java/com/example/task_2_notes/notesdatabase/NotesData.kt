package com.example.task_2_notes.notesdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table") // Creating a Table in the Database
data class NotesData(

    @ColumnInfo(name = "Folder_Name")
    var folderName: String,


    @ColumnInfo(name = "Title")
    var title: String,


    @ColumnInfo(name = "Description")
    var description: String,


    @ColumnInfo(name = "Created_Time")
    var createdTime: Long = System.currentTimeMillis(),


    @ColumnInfo(name = "Modified_Time")
    var modifiedTime: Long = System.currentTimeMillis()
){

    @PrimaryKey(autoGenerate = true)
    var uniqueKey: Int? = null

}