package com.normanaspx.prueba_tecnica.network

import com.normanaspx.prueba_tecnica.model.Dessert
import retrofit2.http.GET

interface DessertService {
    @GET("eeced007-6b29-4c9d-ab63-c115a990d927")
    suspend fun getDesserts(): List<Dessert>
}