package com.example.shimmerapplication.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.model.Data
import com.example.sampleapp.rest.ApiService
import com.example.shimmerapplication.R
import com.example.shimmerapplication.adapter.RecyclerAdapter
import com.example.shimmerapplication.rest.ApiClient
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var shimmerFrameLayout: ShimmerFrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView(){
        recyclerView = findViewById(R.id.recyclerView)
        shimmerFrameLayout = findViewById(R.id.shimmer)
        recyclerView.setHasFixedSize(true)
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        connectAndGetApiData()
    }

    private fun connectAndGetApiData(){

        val apiService: ApiService  = ApiClient.apiService
        val call : Call<List<Data>> = apiService.getDetails()
        call.enqueue(object: Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                val data: List<Data>  = response.body()
                recyclerView.adapter = RecyclerAdapter( data,this@MainActivity)
                shimmerFrameLayout.stopShimmerAnimation()
                shimmerFrameLayout.visibility = View.GONE
            }

            override fun onFailure(call: Call<List<Data>>, throwable:  Throwable) {
                Log.e("Sample", throwable.toString())
            }
        })

    }

    override fun onResume() {
        super.onResume()
        shimmerFrameLayout.startShimmerAnimation()
    }

    override fun onPause() {
        shimmerFrameLayout.stopShimmerAnimation()
        super.onPause()
    }
}
