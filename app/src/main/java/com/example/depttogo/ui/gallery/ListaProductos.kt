package com.example.depttogo.ui.gallery

import com.google.gson.annotations.SerializedName

data class ListaProductos(@SerializedName("nombreProducto") val nombreProducto:String,
                          @SerializedName("descripcion") val descripcion:String,
                          @SerializedName("image") val image: List<String>,
                          @SerializedName("precio") val precio:Float
// el @SerializedName("precio") debe de estar igual al de la llamada de la API


 )