package com.example.simplify1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface UserDataDao {

    @Upsert
    suspend fun upsertLocation(user: Users) // adds a user and their location

    @Delete
    suspend fun deleteUser(user: Users) // deletes a tuple of user wth their location

    @Query("SELECT * FROM Users")
    fun getAllUsers() : List<Users> // Returns a list of all users
}