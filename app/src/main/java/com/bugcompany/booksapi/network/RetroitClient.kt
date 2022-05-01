package com.bugcompany.booksapi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroitClient {
    //Retrofit sınıfını oluşturduğumuz sınıftır.
    companion object {
        fun getClient(baseUrl: String): Retrofit {
            val retrofit = Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit
        }
    }
}