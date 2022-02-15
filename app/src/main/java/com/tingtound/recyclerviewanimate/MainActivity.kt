package com.tingtound.recyclerviewanimate

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(),ItemClickDelegate {
    private var movieList:List<Movie> = listOf()
    private lateinit var mAdapter:MovieAdapter
    private lateinit var recyclerView:RecyclerView
    private lateinit var  layoutManager:LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getMovieList()
        recyclerView=findViewById(R.id.itemList)
        mAdapter= MovieAdapter(movieList,this,this)
        layoutManager=
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager =layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter=mAdapter
    }
    fun getMovieList(){
        var mList:MutableList<Movie> = mutableListOf<Movie>()
        for(i in 0..10){
            var movie=Movie("Movie $i","2021")
            mList.add(movie)
        }
        movieList=mList
    }

    override fun onItemClick(index: Int) {
        Toast.makeText(this,"Item click $index",Toast.LENGTH_LONG).show()
        recyclerView.smoothScrollToPosition(index)
        val firstVisibleItemPosition: Int = layoutManager.findFirstVisibleItemPosition()
        val lastVisibleItemPosition: Int = layoutManager.findLastVisibleItemPosition()

        val centerPosition = (firstVisibleItemPosition + lastVisibleItemPosition) / 2

        if (index > centerPosition) {
            recyclerView.smoothScrollToPosition(index + 1)
        } else if (index <= centerPosition) {
            if(index>0)
            recyclerView.smoothScrollToPosition(index - 1)
        }
    }
}