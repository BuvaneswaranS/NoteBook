package com.example.task_2_notes.notesdatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table") // Creating a Table in the Database
data class NotesData(

    @PrimaryKey(autoGenerate = true)
    var uniqueKey: Long = 0L,


    @ColumnInfo(name = "Folder_Name")
    var folderName: String = "default_folder",


    @ColumnInfo(name = "Title")
    var title: String = "default_title",


    @ColumnInfo(name = "Description")
    var description: String = "default_description",


    @ColumnInfo(name = "Created_Time")
    var createdTime: Long = System.currentTimeMillis(),


    @ColumnInfo(name = "Modified_Time")
    var modifiedTime: Long = System.currentTimeMillis()
)