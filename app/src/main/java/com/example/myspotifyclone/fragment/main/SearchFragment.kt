package com.example.myspotifyclone.fragment.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myspotifyclone.R

class SearchFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView()
    }

    private fun searchView(){
        class MainActivity : AppCompatActivity() {
            // on below line we are
            // creating variables for listview
            lateinit var programmingLanguagesLV: ListView

            // creating array adapter for listview
            lateinit var listAdapter: ArrayAdapter<String>

            // creating array list for listview
            lateinit var programmingLanguagesList: ArrayList<String>;

            // creating variable for searchview
            lateinit var searchView: SearchView

            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_main)

                // initializing variables of list view with their ids.
                programmingLanguagesLV = findViewById(R.id.idLVProgrammingLanguages)
                searchView = findViewById(R.id.idSV)

                // initializing list and adding data to list
                programmingLanguagesList = ArrayList()
                programmingLanguagesList.add("C")
                programmingLanguagesList.add("C#")
                programmingLanguagesList.add("Java")
                programmingLanguagesList.add("Javascript")
                programmingLanguagesList.add("Python")
                programmingLanguagesList.add("Dart")
                programmingLanguagesList.add("Kotlin")
                programmingLanguagesList.add("Typescript")

                // initializing list adapter and setting layout
                // for each list view item and adding array list to it.
                listAdapter = ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    programmingLanguagesList
                )

                // on below line setting list
                // adapter to our list view.
                programmingLanguagesLV.adapter = listAdapter

                // on below line we are adding on query
                // listener for our search view.
                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(query: String?): Boolean {
                        // on below line we are checking
                        // if query exist or not.
                        if (programmingLanguagesList.contains(query)) {
                            // if query exist within list we
                            // are filtering our list adapter.
                            listAdapter.filter.filter(query)
                        } else {
                            // if query is not present we are displaying
                            // a toast message as no  data found..
                            Toast.makeText(this@MainActivity, "No Language found..", Toast.LENGTH_LONG)
                                .show()
                        }
                        return false
                    }

                    override fun onQueryTextChange(newText: String?): Boolean {
                        // if query text is change in that case we
                        // are filtering our adapter with
                        // new text on below line.
                        listAdapter.filter.filter(newText)
                        return false
                    }
                })
            }
        }
    }

}