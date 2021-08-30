package com.example.searchbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.search_screen.*

class search_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_screen)
        val listSearch =
            arrayListOf<String>("bag","laptop","box","c","cpp","java","python","kotlin","apple","cap","hat")

        var adapter_listSearch = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listSearch)
        listView.adapter = adapter_listSearch

        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                var s:String?=newText
                if(s?.isEmpty()==true) {
                    listView.visibility = View.GONE
                    return false
                }
                else{
                    listView.visibility=View.VISIBLE
                    adapter_listSearch.filter.filter(newText)
                }
                return false
            }


            override fun onQueryTextSubmit(query: String?): Boolean {
                if(listSearch.contains(query)){
                    adapter_listSearch.filter.filter(query)
                }else
                    Toast.makeText(this@search_activity,"No results found",Toast.LENGTH_SHORT).show()

                return false
            }
        })
    }
}