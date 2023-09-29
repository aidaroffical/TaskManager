package com.example.taskmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class OnBoarding(
    @PrimaryKey(autoGenerate = true)
    val uid: Int? = null,
    val image:String? = null,
    val tittle:String? = null,
    val desc:String? = null
)
