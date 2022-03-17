package com.example.hilt.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val name: String
) {
    override fun toString(): String {
        return String.format("name %s", name)
    }
}
