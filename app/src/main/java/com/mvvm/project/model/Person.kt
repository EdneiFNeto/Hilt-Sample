package com.mvvm.project.model

class Person(
    val id: Long?,
    val firstname: String,
    val lastname: String,
    val email: String,
    val phone: String,
    val birthday: String,
    val gender: String,
    val website: String,
    val image: String,
    val address: Address
) {
    override fun toString(): String {
        return String.format(
            "firstname: %s, lastname: %s, email: %s, phone: %s, birthday: %s, gender: %s, address: %s, image: %s, website: %s",
            lastname, firstname, email, phone, birthday, gender, address, image, website
        )
    }
}
