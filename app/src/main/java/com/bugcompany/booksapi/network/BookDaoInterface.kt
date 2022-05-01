package com.bugcompany.booksapi.network

import com.bugcompany.booksapi.response.BookResponseModel
import retrofit2.Call
import retrofit2.http.GET

interface BookDaoInterface {
    @GET("all_books.php")
    fun getBook(): Call<BookResponseModel>
}