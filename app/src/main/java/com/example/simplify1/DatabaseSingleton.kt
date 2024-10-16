// DatabaseSingleton.kt
package com.example.simplify1

import android.content.Context
import androidx.room.Room

object DatabaseSingleton {

    @Volatile
    private var INSTANCE: UserDatabase? = null

    fun getDatabase(context: Context): UserDatabase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                UserDatabase::class.java,
                "user_database"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}
