package com.normanaspx.prueba_tecnica.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val idUser: Int = 0,
    var username: String,
    var password: String
){
    constructor(pusername: String, ppassword: String) : this(username = pusername, password = ppassword)
}