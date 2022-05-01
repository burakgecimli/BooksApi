package com.bugcompany.booksapi.network

class ApiUtils {
    //http://books.canerture.com/
    companion object {
        private const val BASE_URL = "http://books.canerture.com/"

        fun getBookDaoInterface(): BookDaoInterface {
            val retrofit = RetroitClient.getClient(BASE_URL)
            val service = retrofit.create(BookDaoInterface::class.java)
            return service
        }
    }
}