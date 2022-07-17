package com.goldenray.nytimesbooks.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApiService {

    private fun initRetrofit(): Retrofit{
        //inicia o retrofit
        return Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/svc/books/v3/")
            .addConverterFactory(MoshiConverterFactory.create())// fala que mosh ira passar de json para kotlin
            .build()
    }
    val service :NYTServices = initRetrofit().create(NYTServices::class.java)//associo a classe que tem os endpoints da api ao retrofit
}