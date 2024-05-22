package com.example.room.Data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User_Table")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val Name:String,
    val password: String,
    val Email: String,
    val phone: String,

)