package com.example.depttogo.retrofit

import com.example.depttogo.ui.gallery.ListaProductos
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url

interface IProductos {

    @GET("productos")
    fun listProductos(): Call<List<ListaProductos>>

   // @GET
   // fun (@Url url:String):Response< >

}