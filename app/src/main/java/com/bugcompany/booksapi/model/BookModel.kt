package com.bugcompany.booksapi.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class BookModel(
    @SerializedName("book_id") @Expose val book_id: Int,
    @SerializedName("book_name") @Expose val book_name: String,
    @SerializedName("book_author") @Expose val book_author: String,
    @SerializedName("book_publisher") @Expose val book_publisher: String,
    @SerializedName("book_price") @Expose val book_price: Double,
    @SerializedName("book_image_url") @Expose val book_image_url: String
) : Serializable


