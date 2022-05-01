package com.bugcompany.booksapi.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bugcompany.booksapi.adapter.BookAdapter
import com.bugcompany.booksapi.databinding.FragmentHomeBinding
import com.bugcompany.booksapi.model.BookModel
import com.bugcompany.booksapi.network.ApiUtils
import com.bugcompany.booksapi.response.BookResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    var bookList: ArrayList<BookModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        loadBook()
        return binding.root
    }

    private fun loadBook() {
        ApiUtils.getBookDaoInterface().getBook()
            .enqueue(object : Callback<BookResponseModel> {
                override fun onResponse(call: Call<BookResponseModel>, response: Response<BookResponseModel>) {
                    val tempList = response.body()?.books
                    tempList?.let {
                        bookList = it as ArrayList<BookModel>
                    }
                    val adapter = BookAdapter(bookList)
                    binding.rv.adapter = adapter
                    binding.rv.setHasFixedSize(true)
                    binding.rv.layoutManager = GridLayoutManager(context, 2)
                }

                override fun onFailure(call: Call<BookResponseModel>, t: Throwable) {
                    t.printStackTrace()
                }
            })
    }

}