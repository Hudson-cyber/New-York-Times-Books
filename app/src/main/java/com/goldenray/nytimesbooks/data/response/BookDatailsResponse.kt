package com.goldenray.nytimesbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BookDatailsResponse(
    @Json(name = "title")
    val title : String,
    @Json(name = "description")
    val description : String,
    @Json(name = "author")// se o nome da variavel for igual o da api não precisa do json
    val author : String
)