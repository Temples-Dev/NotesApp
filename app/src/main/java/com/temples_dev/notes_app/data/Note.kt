package com.temples_dev.notes_app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    val title:String,
    val description:String,
    val dateAdded:Long,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
