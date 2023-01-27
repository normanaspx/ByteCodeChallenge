package com.normanaspx.prueba_tecnica.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.normanaspx.prueba_tecnica.model.User


@Dao
interface DessertDao {

    @Query("select * from User where username =:username and password =:password")
    fun getUserByCredentials(username: String, password:String) :LiveData<List<User>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)
}