    package com.example.depttogo.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.nio.file.attribute.AclEntry

class RetrofitClase {

    companion object{

        fun getRetrofit(): Retrofit{

            val retrofit = Retrofit.Builder()
                .baseUrl("http://www.proyecto8vo.byethost3.com/ProyectoFanny/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
                return retrofit;

        }
    }
}