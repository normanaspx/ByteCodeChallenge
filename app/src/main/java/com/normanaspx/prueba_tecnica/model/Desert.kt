package com.normanaspx.prueba_tecnica.model

import com.google.gson.annotations.SerializedName

data class Dessert (
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String,
    @SerializedName("name") val name : String,
    @SerializedName("ppu") val ppu : Double,
    @SerializedName("batters") val batters : Batters,
    @SerializedName("topping") val topping : List<Topping>
)

data class Batters (
    @SerializedName("batter") val batter : List<Batter>
)


data class Batter (
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String
)

data class Topping (
    @SerializedName("id") val id : Int,
    @SerializedName("type") val type : String
)