package com.mvvm.project.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity
class Teste(
    @PrimaryKey(autoGenerate = true)
    val id: Long?,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val birthday: String,
    val gender: String,
    val website: String,
    val image: String
) {
    @Ignore
    val address: ArrayList<Address>? = null

    override fun toString(): String {
        return String.format(
            "firstname: %s, lastname: %s, email: %s, phone: %s, birthday: %s, gender: %s, address: %s, image: %s, website: %s",
            lastname, firstname, email, phone, birthday, gender, address, image, website
        )
    }
}
