package com.example.hw_1_4m

import java.io.Serializable

data class User(
    val name: String,
    val email: String,
    val password: Int
): Serializable
