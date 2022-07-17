package com.goldenray.nytimesbooks.data

import com.goldenray.nytimesbooks.data.model.Books
import com.goldenray.nytimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTServices {
    @GET("lists.json")
    fun getBooks(
        //parametros que ja contem um valor default de apikey e list
        @Query("api-key") apiKey : String = "v7SBsrMPKUXniuqMbqO0ARGcFOPhFNQi",
        @Query("list") list: String ="hardcover-fiction" //exemplo default
        //list é o nome da notificação
    ): Call<BookBodyResponse>
}