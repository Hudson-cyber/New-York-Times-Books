package com.goldenray.nytimesbooks.presentation.books

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.goldenray.nytimesbooks.R
import com.goldenray.nytimesbooks.databinding.ActivityBooksBinding
import androidx.recyclerview.widget.DividerItemDecoration





class BooksActivity : AppCompatActivity() {
    //criamos uma variavel lateinit biding
    private lateinit var binding: ActivityBooksBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // tem  que mexer no app.gradle
        //  ActivityBooksBinding é a classe criada automaticamente para associar os arquivos xml da tela a uma classe java
        //aqui estamos carregando(instanciando) ela
        binding = ActivityBooksBinding.inflate(layoutInflater)
        //aqui estamos pegando a raiz do xml
        val view = binding.root
        //aqui estamos tornando a visualização ativa na tela
        setContentView(view)

        //para acessar os componentes na tela binding + id
        // criando tollbar
        binding.toolbarMain.title = getString(R.string.toolbar_name)
        setSupportActionBar(binding.toolbarMain)

        // passando o contexto da activity no this,o view model provider é uma feature do view model que usaremos como base para o nosso view model
        val viewModel: BooksViewModel = ViewModelProvider(this).get(BooksViewModel::class.java)

        viewModel.booksLiveData.observe(this, {
            //aqui observamos se o boosLivedata tem alguma modificação para colocarmos ela na activity
            //pode ser nulo por isso o let para evitar execução nula
            it?.let {
                //passando adapter ao recyclerView
                    books ->
                with(binding.recyclerBooks) {
                    layoutManager = LinearLayoutManager(
                        this@BooksActivity,
                        RecyclerView.VERTICAL,
                        false
                    )// horientação
                    // o this esta com o nome da activity pois nos estamos no contexto RecyclerView
                    setHasFixedSize(true) //as listas tem tamanho fixo
                    this.addItemDecoration(
                        DividerItemDecoration(
                            context,
                            DividerItemDecoration.HORIZONTAL
                        )
                    )
                    adapter = BooksAdapter(books)
                }
            }
        })
        viewModel.getBooks()

    }
}


