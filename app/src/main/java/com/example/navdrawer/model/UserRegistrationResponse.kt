package com.example.navdrawer.model

data class UserRegistrationResponse (
    val token: String? ="",
    val id: String = "",
    val name: String = "",
    val lastname: String = "",
    val phone: Int = 0,
    //val createdAt: String="",
    //val updatedAt: String=""
)
