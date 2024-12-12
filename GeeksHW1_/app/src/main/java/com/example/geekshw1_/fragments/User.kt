package com.example.hw1_geeks_1.fragments

import java.io.Serializable

data class User(
    val name : String ,
    val email : String ,
    val password : Int

) : Serializable