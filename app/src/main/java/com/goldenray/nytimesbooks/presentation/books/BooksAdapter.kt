package com.goldenray.nytimesbooks.presentation.books

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goldenray.nytimesbooks.R
import com.goldenray.nytimesbooks.data.model.Books


class BooksAdapter(
    private val books: List<Books>
) : RecyclerView.Adapter<BooksAdapter.BooksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BooksViewHolder {
        val view = LayoutInflater. from(parent.context).inflate(R.layout.item_books,parent,false)
        return BooksViewHolder(view)
    }

    override fun onBindViewHolder(holder: BooksViewHolder, position: Int) {
            holder.bindView(books[position])
    }

    override fun getItemCount() = books.count()

    class BooksViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val title = view.findViewById<TextView>(R.id.title)
         private val author = view.findViewById<TextView>(R.id.author)
        fun bindView(book:Books){
            title.text = book.title
            author.text = book.author
        }
    }

}