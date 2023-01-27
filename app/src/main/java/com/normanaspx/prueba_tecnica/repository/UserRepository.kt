package com.normanaspx.prueba_tecnica.repository

import androidx.lifecycle.LiveData
import com.normanaspx.prueba_tecnica.db.DessertDao
import com.normanaspx.prueba_tecnica.model.Dessert
import com.normanaspx.prueba_tecnica.model.User
import com.normanaspx.prueba_tecnica.network.DessertService
import com.normanaspx.prueba_tecnica.utils.Response
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class UserRepository @Inject constructor(private val service: DessertDao)  {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)


   fun getLoginDetails(character: User): LiveData<List<User>>  {
       return service.getUserByCredentials(character.username, character.password)
    }

    fun addUser(user: User) {
        coroutineScope.launch(Dispatchers.IO) {
            service.insertUser(user)
        }
    }
}