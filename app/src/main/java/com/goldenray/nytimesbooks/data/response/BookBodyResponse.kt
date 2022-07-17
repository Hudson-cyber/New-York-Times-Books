package com.goldenray.nytimesbooks.data.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)// gera  o processador  de anotação que gera os bolerolate em tempo de compilação
data class BookBodyResponse(
    @Json(name = "results")// nome da list na api associando a api a classe
    val booksResults :List <BookResultResponse>// esse é um mapeamento dos itens dentro de um objeto na API
)