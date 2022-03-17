package com.example.hilt.domain.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.hilt.domain.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun all(): List<User>

    @Insert
    fun insert(user: User): Long

    @Delete
    fun delete(user: User): Int
}
