package com.bugcompany.booksapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bugcompany.booksapi.databinding.BookcardDesignBinding
import com.bugcompany.booksapi.model.BookModel
import com.squareup.picasso.Picasso

class BookAdapter(val bookList: ArrayList<BookModel>) :
    RecyclerView.Adapter<BookAdapter.BookCard>() {

    inner class BookCard(val binding: BookcardDesignBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookCard {
        val binding = BookcardDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BookCard(binding)
    }

    override fun onBindViewHolder(holder: BookCard, position: Int) {
        val book = bookList[position]
        holder.binding.apply {
            textViewBook.text = book.book_name
            Picasso.get().load(book.book_image_url).into(imageViewBook)
            textViewAuthor.text = book.book_author
            textViewPrice.text = "${book.book_price} TL"
            textViewPublisher.text = book.book_publisher
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

}