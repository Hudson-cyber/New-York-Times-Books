package com.goldenray.nytimesbooks.presentation.books

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.goldenray.nytimesbooks.data.ApiService
import com.goldenray.nytimesbooks.data.model.Books
import com.goldenray.nytimesbooks.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {
    val booksLiveData: MutableLiveData<List<Books>> = MutableLiveData()

    fun getBooks() {
        // ele é responsavwl por ir na api e pegar os books quando tiver mudançase passar para activity
        //booksLiveData.value = createFakeBooks()
        //Retrofit, seria legal usar injestão de dependencia,ou criar outra camada que contenha o retrofit
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse>{
            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {// quando ter algum erro do 200 ate o 400
                if (response.isSuccessful){
                    Log.d("BooksViewModel","API conectada com sucesso")
                    val books : MutableList<Books> = mutableListOf()

                    response.body()?.let{
                        for(results in it.booksResults){
                            //nessa api eu tenho um objeto na posição 0 e dentro do objeto que esta a lista então temos q adaptar
                            val book  = Books(
                                title = results.booksDetails[0].title,
                                author = results.booksDetails[0].author
                            )
                            books.add(book)
                        }
                    }
                    booksLiveData.postValue(books)
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {
                TODO("Not yet implemented")
                // erro 500
            }

        })
        //depois do get books eu vou ter algunsmetodos proprios do retrofit dentre eles:
        //enqueue(), que gera requisiçõa de forma asincrona, ele espera receber um Callback para criar ele usar o Callback do retrofit
        //execute(), que faz de forma sincrona bloqueando a aplicação

    }

}