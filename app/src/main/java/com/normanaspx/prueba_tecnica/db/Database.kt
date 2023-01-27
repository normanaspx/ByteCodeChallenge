package com.normanaspx.prueba_tecnica.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.normanaspx.prueba_tecnica.model.User
import com.normanaspx.prueba_tecnica.utils.Constants


/**
Created by Norman on 11/16/2022
 **/
@Database(
    entities = [User::class],
    version = Constants.DB_VERSION,
    exportSchema = false
)
abstract class Database : RoomDatabase(){
    abstract fun dessertDao(): DessertDao
}