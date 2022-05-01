package com.bugcompany.booksapi.response

import com.bugcompany.booksapi.model.BookModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BookResponseModel(
    @SerializedName("books")
    @Expose val books: List<BookModel>,
    @SerializedName("success")
    @Expose val success: Int
)

