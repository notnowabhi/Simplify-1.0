package com.example.simplify1

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Users(
    val firstName : String,
    val lastName : String,
    val phoneNumber : String,
    val lastLocation : String, //for now, we will only store city name for simplification
    @PrimaryKey(autoGenerate = true)
    val id : Int
)