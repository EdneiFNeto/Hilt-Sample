package com.example.hilt.domain.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hilt.domain.User
import com.example.hilt.domain.database.dao.UserDao

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}