package com.example.depttogo.retrofit

import com.example.depttogo.ui.gallery.ListaProductos
import retrofit2.Call
import retrofit2.http.GET

interface IProductos {

    @GET("productos")
    fun listProductos(): Call<List<ListaProductos>>

}