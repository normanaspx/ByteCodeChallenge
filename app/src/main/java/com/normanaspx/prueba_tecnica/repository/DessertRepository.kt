package com.normanaspx.prueba_tecnica.repository

import com.normanaspx.prueba_tecnica.model.Dessert
import com.normanaspx.prueba_tecnica.network.DessertService
import com.normanaspx.prueba_tecnica.utils.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class DessertRepository @Inject constructor(private val service: DessertService) {

    fun getDessertsFromNetwork(): Flow<Response<List<Dessert>>> = flow{
        try {
            emit(Response.Loading)
            val responseApi = service.getDesserts()
            emit(Response.Success(responseApi))
        } catch (e: Exception) {
            emit(Response.Failure(e))
        }
    }.flowOn(Dispatchers.IO)

}